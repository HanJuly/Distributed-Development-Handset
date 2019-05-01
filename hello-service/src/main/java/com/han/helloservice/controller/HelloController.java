package com.han.helloservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/getHello")
    public String getHello(){
        System.out.println("Get hello starting...........");
        int sleepMill = new Double(Math.random()*1000).intValue();
        try {
            Thread.sleep(sleepMill);
            System.out.println(String.format("Sleep %s mill.",sleepMill));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("Hello,I am here. %s",sleepMill);
    }

}
