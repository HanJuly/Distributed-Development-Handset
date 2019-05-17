package com.han.helloconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RibbonClient(name = "hello-consumer")
@SpringBootApplication(scanBasePackages={"com.han.helloconsumer","com.hw.common","com.wh.gray"})
public class HelloConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloConsumerApplication.class, args);
	}

}
