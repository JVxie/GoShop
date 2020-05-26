package com.jvxie.goshop.listener;

import com.google.gson.Gson;
import com.jvxie.goshop.model.Order;
import com.jvxie.goshop.model.OrderPay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ监听支付成功回传消息
 */

@Slf4j
@Component
@RabbitListener(queues = "payNotify")
public class PayMessageListener {
    @RabbitHandler
    public void process(String msg) {
        log.info("接收到消息： {}", msg);
        /**
         * 这里要注意不应该这么写
         * 应使用client.jar连接另一个系统的实体
         */
        OrderPay orderPay = new Gson().fromJson(msg, OrderPay.class);
        if (orderPay.getOrderPayStatus().equals("SUCCESS")) {

        }
    }
}
