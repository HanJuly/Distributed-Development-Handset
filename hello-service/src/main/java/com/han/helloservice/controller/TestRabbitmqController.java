package com.han.helloservice.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestRabbitmqController {
    @Autowired
    AmqpTemplate amqpTemplate;


    @RequestMapping("/sendRabbitMessage")
    public String send(){
        amqpTemplate.convertAndSend("hello",String.format("Rabbit message %s",new Date().toString()));
        return "Send successfully.";
    }
}