package com.gupaoedu.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
    private Logger logger = LoggerFactory.getLogger(SecondConsumer.class);

    @RabbitHandler
    public void process(String msg){
        System.out.println("Second Queue received msg : " + msg);
    }
}
