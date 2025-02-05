package com.emarket.market.listener;

import com.emarket.market.Service.impl.OrderServiceImpl;
import com.emarket.market.pojo.PayInfo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "payNotify")
public class PayMsgListener {

    private final OrderServiceImpl orderServiceImpl;

    public PayMsgListener(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @RabbitHandler
    public void process(String msg) {
        log.info("Received payNotify message: {}", msg);

        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if(payInfo.getPlatformStatus().equals("SUCCESS")) {
            orderServiceImpl.paid(payInfo.getOrderNo());
        }
    }
}
