package com.han.helloservice;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig  {
    @Bean
    public Queue configQueue(){
        return new Queue("hello");
    }

}
