package com.han.helloconsumer.controller;

import com.han.helloconsumer.service.HelloServiceCommand;
import com.hw.common.redis.RedisUtil;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/helloConsumer")
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloServiceCommand helloServie;


    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/getHello")
    public String getHello() {
        HystrixRequestContext.initializeContext();
        LOGGER.info("Test logback for zipkin");
        System.out.println(helloServie.getHello(123l));
        System.out.println(helloServie.getHello(123l));
        testRedis();
        helloServie.updateHello(123L);
        System.out.println("After cache remove:" + helloServie.getHello(123l));
        return helloServie.getHello(123l);
    }

    private  void  testRedis() {

        Map<String, String> testMap = new HashMap();
        testMap.put("name", "han");
        testMap.put("age", "21");
        testMap.put("class", "一般");
        redisUtil.hmset("commonRedis",testMap);
    }


}
