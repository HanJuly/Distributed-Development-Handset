package com.han.helloconsumer.controller;

import com.han.helloconsumer.service.HelloServiceCommand;
import com.han.helloconsumer.service.HelloServie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/helloconsumer")
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloServiceCommand helloServie;


    @GetMapping("/getHello")
    public String getHello(){
        HystrixRequestContext.initializeContext();
        LOGGER.info("Test logback for zipkin");
        System.out.println(helloServie.getHello(123l));
        System.out.println(helloServie.getHello(123l));

        helloServie.updateHello(123L);
        System.out.println("After cache remove:"+helloServie.getHello(123l));
        return helloServie.getHello(123l);
    }



}
