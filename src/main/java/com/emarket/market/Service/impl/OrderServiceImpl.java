package com.emarket.market.Service.impl;

import com.emarket.market.Service.OrderService;
import com.emarket.market.dao.OrderItemMapper;
import com.emarket.market.dao.OrderMapper;
import com.emarket.market.dao.ProductMapper;
import com.emarket.market.dao.ShippingMapper;
import com.emarket.market.enums.OrderStatusEnum;
import com.emarket.market.enums.PaymentTypeEnum;
import com.emarket.market.enums.ProductStatusEnum;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.pojo.*;
import com.emarket.market.vo.OrderItemVo;
import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ShippingMapper shippingMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByUidAndShippingId(uid, shippingId);

        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }
        List<Cart> cartList = cartService.listAll(uid);
        Set<Cart> cartSet = cartList.stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toSet());
        if(CollectionUtils.isEmpty(cartSet)) {
            return ResponseVo.error(ResponseEnum.CART_SELECTED_IS_EMPTY);
        }

        List<Product> productList = productMapper.selectByProductIdSet(cartSet.stream()
                .map(Cart::getProductId)
                .collect(Collectors.toSet()));
        Map<Integer, Product> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));
        List<OrderItem> orderItemList = new ArrayList<>();
        Long orderNo = generateOrderNo();
        for(Cart cart : cartList) {
            Product product = productMap.get(cart.getProductId());
            if(product == null) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,  cart.getProductId() + "Product not exist");
            }
            if(!ProductStatusEnum.ON_SALE.getCode().equals(product.getStatus())) {
                return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE, product.getName() + "off sale");
            }
            if(product.getStock() < cart.getQuantity()) {
                return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR, product.getName() + "Stock is not enough");
            }

            OrderItem orderItem = buildOrderItem(uid, orderNo, cart, product);
            orderItemList.add(orderItem);

            product.setStock(product.getStock() - cart.getQuantity());
            int count = productMapper.updateByPrimaryKeySelective(product);
            if(count <= 0) {
                return ResponseVo.error(ResponseEnum.ERROR);
            }
        }

        Order order = buildOrder(uid, orderNo, shippingId, orderItemList);

        int count = orderMapper.insertSelective(order);
        if(count <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        count = orderItemMapper.batchInsert(orderItemList);
        if(count <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        for(Cart cart : cartList) {
            cartService.delete(uid, cart.getProductId());
        }

        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectByUid(uid);
        
        Set<Long> orderNoSet = orderList.stream().map(Order::getOrderNo)
                .collect(Collectors.toSet());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNoSet(orderNoSet);

        Map<Long, List<OrderItem>> orderItemMap = orderItemList.stream()
                .collect(Collectors.groupingBy(OrderItem::getOrderNo));

        Set<Integer> shippingIdSet = orderList.stream().map(Order::getShippingId)
                .collect(Collectors.toSet());
        List<Shipping> shippingList = shippingMapper.selectByShippingIdSet(shippingIdSet);
        Map<Integer, Shipping> shippingMap = shippingList.stream()
                .collect(Collectors.toMap(Shipping::getId, s -> s));

        List<OrderVo> orderVoList = new ArrayList<>();
        for(Order order : orderList) {
            OrderVo orderVo = buildOrderVo(order,
                    orderItemMap.get(order.getOrderNo()),
                    shippingMap.get(order.getShippingId()));
            orderVoList.add(orderVo);
        }

        PageInfo pageInfo = new PageInfo<>(orderList);
        pageInfo.setList(orderVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<OrderVo> detail(Integer uid, Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        if(order == null || !order.getUserId().equals(uid)) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_EXIST);
        }
        Set<Long> orderNoSet = new HashSet<>();
        orderNoSet.add(order.getOrderNo());
        List<OrderItem> orderItemList = orderItemMapper.selectByOrderNoSet(orderNoSet);

        Shipping shipping = shippingMapper.selectByPrimaryKey(order.getShippingId());

        OrderVo orderVo = buildOrderVo(order, orderItemList, shipping);

        return ResponseVo.success(orderVo);
    }

    private OrderVo buildOrderVo(Order order, List<OrderItem> orderItemList, Shipping shipping) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);

        List<OrderItemVo> orderItemVoList = orderItemList.stream().map(e -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(e, orderItemVo);
            return orderItemVo;
        }).toList();
        orderVo.setOrderItemVoList(orderItemVoList);

        if(shipping != null) {
            orderVo.setShippingId(shipping.getId());
            orderVo.setShippingVo(shipping);
        }
        return orderVo;
    }

    private Order buildOrder(Integer uid, Long orderNo, Integer shippingId, List<OrderItem> orderItemList) {
        BigDecimal payment = orderItemList.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(uid);
        order.setShippingId(shippingId);
        order.setPayment(payment);
        order.setPaymentType(PaymentTypeEnum.PAY_ONLINE.getCode());
        order.setPostage(0);
        order.setStatus(OrderStatusEnum.NO_PAY.getCode());
        return order;

    }

    private OrderItem buildOrderItem(Integer uid, Long orderNo, Cart cart, Product product) {
        OrderItem item = new OrderItem();
        item.setUserId(uid);
        item.setOrderNo(orderNo);
        item.setProductId(product.getId());
        item.setProductName(product.getName());
        item.setProductImage(product.getMainImage());
        item.setCurrentUnitPrice(product.getPrice());
        item.setQuantity(cart.getQuantity());
        item.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())));
        return item;
    }
    private Long generateOrderNo() {
        return System.currentTimeMillis() + new Random().nextInt(100);
    }
}
