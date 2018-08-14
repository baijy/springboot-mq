package com.gupaoedu.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 生产者发送消息
 */
@Component
public class HelloProvider {
    private Logger log = LoggerFactory.getLogger(HelloProvider.class);

    // 读取配置
    @Value("${my.exchange.topic}")
    private String topicExchange;

    @Value("${my.exchange.fanout}")
    private String fanoutExchange;

    @Value("${my.queue.first}")
    private String firstQueue;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        // Direct 模式
        amqpTemplate.convertAndSend(firstQueue,"a direct message ");

        // Topic模式
        amqpTemplate.convertAndSend(topicExchange,"changsha.food.today","a topic msg : changsha.food.today");
        amqpTemplate.convertAndSend(topicExchange,"nanjing.food.yestoday","a topic msg : nanjing.food.yestoday");

        // Fanout模式
        amqpTemplate.convertAndSend(fanoutExchange,"","a fanout msg");




    }



}
