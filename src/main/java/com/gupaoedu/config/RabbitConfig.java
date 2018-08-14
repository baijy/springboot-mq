package com.gupaoedu.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 *
 */
public class RabbitConfig {

    // 读取配置文件
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

    // 定义队列
    @Bean(name = "firstQueue")
    public Queue getFirstQueue() {
        return new Queue(firstQueue);
    }

    @Bean(name = "secondQueue")
    public Queue getSecondQueue() {
        return new Queue(secondQueue);
    }

    @Bean(name = "thirdQueue")
    public Queue getThirdQueue() {
        return new Queue(thirdQueue);
    }

    // 定义交换机
    @Bean(name = "topicExchange")
    public TopicExchange getTopicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean(name = "fanoutExchange")
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    // 定义绑定关系
    @Bean
    Binding bindingSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange")TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.food.#");
    }

    @Bean
    Binding bindingThird(@Qualifier("thirdQueue") Queue queue, 	@Qualifier("fanoutExchange")FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
