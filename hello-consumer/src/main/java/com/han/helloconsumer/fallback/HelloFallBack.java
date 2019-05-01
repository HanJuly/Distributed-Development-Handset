package com.han.helloconsumer.fallback;

import com.han.helloconsumer.service.HelloServie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("fallback")
public class HelloFallBack implements HelloServie {
    @Override
    public String getHello() {
        return "hello,this is a fall back.";
    }
}
