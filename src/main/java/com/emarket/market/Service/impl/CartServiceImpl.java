package com.emarket.market.Service.impl;

import com.emarket.market.Service.CarService;
import com.emarket.market.dao.ProductMapper;
import com.emarket.market.enums.ProductStatusEnum;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.form.CartUpdateForm;
import com.emarket.market.pojo.Cart;
import com.emarket.market.pojo.Product;
import com.emarket.market.vo.CartProductVo;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CarService {
    private final static String CART_REDIS_KEY_TEMPLATE = "cart_%d";
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm) {
        Product product = productMapper.selectByPrimaryKey(cartAddForm.getProductId());
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }
        if(product.getStatus().equals(ProductStatusEnum.OFF_SALE.getCode())
            || product.getStatus().equals(ProductStatusEnum.DELETE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        if(product.getStock() <= 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = opsForHash.get(redisKey, String.valueOf(product.getId()));
        Cart cart;
        if(value == null) {
            cart = new Cart(product.getId(), 1, cartAddForm.getSelected());
        } else {
            cart = new Gson().fromJson(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + 1);
        }
        opsForHash.put(redisKey,
                String.valueOf(product.getId()),
                new Gson().toJson(cart));
        return listCart(uid);
    }

    @Override
    public ResponseVo<CartVo> listCart(Integer uid) {
        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        Map<String, String> entries = opsForHash.entries(redisKey);

        Set<Integer> productIdSet = entries.keySet().stream()
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
        List<Product> products = productMapper.selectByProductIdSet(productIdSet);

        Map<Integer, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        CartVo cartVo = new CartVo();
        ArrayList<CartProductVo> cartProductVos = new ArrayList<>();
        Boolean selectAll = true;
        Integer cartTotalQuantity = 0;
        BigDecimal cartTotalPrice = BigDecimal.ZERO;
        for(Map.Entry<String, String> entry : entries.entrySet()) {
            Cart cart = new Gson().fromJson(entry.getValue(), Cart.class);
            Integer productId = Integer.valueOf(entry.getKey());

            if(productMap.get(productId) != null) {
                Product product = productMap.get(productId);
                CartProductVo cartProductVo = new CartProductVo(productId,
                        cart.getQuantity(),
                        product.getName(),
                        product.getSubtitle(),
                        product.getMainImage(),
                        product.getPrice(),
                        product.getStatus(),
                        product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                        product.getStock(),
                        cart.getProductSelected());
                cartProductVos.add(cartProductVo);

                if(!cart.getProductSelected()) {
                    selectAll = false;
                }
                if(cart.getProductSelected()) {
                    cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
                }
            }
            cartTotalQuantity += cart.getQuantity();
        }
        cartVo.setCartProductVoList(cartProductVos);
        cartVo.setCartTotalQuantity(cartTotalQuantity);
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setSelectAll(selectAll);
        return ResponseVo.success(cartVo);
    }

    @Override
    public ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm) {
        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = opsForHash.get(redisKey, String.valueOf(productId));
        Cart cart;
        if(value == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }
        cart = new Gson().fromJson(value, Cart.class);
        if(cartUpdateForm.getQuantity() != null
                && cartUpdateForm.getQuantity() >= 0) {
            cart.setQuantity(cartUpdateForm.getQuantity());
        }
        if(cartUpdateForm.getSelected() != null) {
            cart.setProductSelected(cartUpdateForm.getSelected());
        }
        opsForHash.put(redisKey, String.valueOf(productId), new Gson().toJson(cart));
        return listCart(uid);
    }

    @Override
    public ResponseVo<CartVo> delete(Integer uid, Integer productId) {
        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = opsForHash.get(redisKey, String.valueOf(productId));
        if(value == null) {
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        opsForHash.delete(redisKey, String.valueOf(productId));
        return listCart(uid);
    }
}
