package com.gupaoedu.config;

import org.springframework.beans.factory.annotation.Value;

public class RabbitConfig {

    @Value("${my.queue.first}")
    private String firstQueue;

    @Value("${my.queue.second}")
    private String secondQueue;

    @Value("${my.queue.third}")
    private String thirdQueue;

    @Value("${my.exchange.topic}")
    private String topicExchange;

    @Value("${my.exchange.fanout}")
    private String fanoutExchange;


}
