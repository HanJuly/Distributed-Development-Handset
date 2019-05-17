package com.han.helloconsumer.controller;

import com.han.helloconsumer.service.HelloServiceCommand;
import com.han.helloconsumer.service.HelloServie;
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
        return getString();
    }

    private String getString() {
        LOGGER.info("Test logback for zipkin");
        System.out.println(helloServie.getHello(1213L));
        System.out.println(helloServie.getHello(1213L));
//        testRedis();
//        helloServie.updateHello(123L);
        System.out.println("After cache remove:" + helloServie.getHello(1213L));
        return helloServie.getHello(1213L);
    }

    private  void  testRedis() {

        Map<String, String> testMap = new HashMap();
        testMap.put("name", "han");
        testMap.put("age", "21");
        testMap.put("class", "一般");
        redisUtil.hmset("commonRedis",testMap);
    }


}
