package com.consumer.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SendConf {

    @Bean
    public Queue queue(){
        return new Queue("queue");
    }
}
