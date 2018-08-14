package com.gupaoedu.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${my.queue.first}")
public class FirstConsumer {
    private Logger logger = LoggerFactory.getLogger(FirstConsumer.class);

    @RabbitHandler
    public void process(String msg){
        logger.info(" Firset queue received msg: " + msg);
    }
}
