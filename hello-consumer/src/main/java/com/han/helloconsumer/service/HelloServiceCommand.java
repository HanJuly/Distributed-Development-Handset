package com.han.helloconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceCommand {
    @Autowired
    HelloServie helloServie;

    @CacheResult
    @HystrixCommand(groupKey = "hello",commandKey = "getHello",commandProperties = {
            @HystrixProperty(name="requestCache.enabled",value = "true")
    })
    public String getHello(@CacheKey Long id){
       return helloServie.getHello();
    }

    @CacheRemove(commandKey = "getHello")
    @HystrixCommand(groupKey = "hello",commandKey = "updateHello")
    public String updateHello(@CacheKey Long id){
        return helloServie.getHello();
    }
}
