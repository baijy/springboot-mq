package com.gupaoedu.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者发送消息
 */
@Component
public class HelloProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){

        // Direct 模式
        amqpTemplate.convertAndSend("FIRST_QUEUE","a direct message ");

        // Topic模式
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","changsha.food.today","a topic msg : changsha.food.today");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","nanjing.food.tomorrow","a topic msg : nanjing.food.tomorrow");

        // Fanout模式
        amqpTemplate.convertAndSend("FANOUT_EXCHANGE","","a fanout msg");




    }



}
