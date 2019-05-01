package com.han.helloconsumer.service;

import com.han.helloconsumer.fallback.HelloFallBack;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "HELLO-PROVIDE", fallback = HelloFallBack.class)
@RequestMapping("/hello")
public interface HelloServie {

    @GetMapping("/getHello")
    public String getHello();


}
