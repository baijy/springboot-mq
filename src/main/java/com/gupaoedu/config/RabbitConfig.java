package com.gupaoedu.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 */
@Configuration
public class RabbitConfig {

    // 定义3个队列
    @Bean(name = "firstQueue")
    public Queue getFirstQueue() {
        return new Queue("FIRST_QUEUE");
    }

    @Bean(name = "secondQueue")
    public Queue getSecondQueue() {
        return new Queue("SECOND_QUEUE");
    }

    @Bean(name = "thirdQueue")
    public Queue getThirdQueue() {
        return new Queue("THIRD_QUEUE");
    }

    // 定义2个交换机
    @Bean(name = "topicExchange")
    public TopicExchange getTopicExchange() {
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    @Bean(name = "fanoutExchange")
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    // 定义绑定关系
    @Bean
    Binding bindingSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange")TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.food.#");
    }

    @Bean
    Binding bindingThird(@Qualifier("thirdQueue") Queue queue, @Qualifier("fanoutExchange")FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
