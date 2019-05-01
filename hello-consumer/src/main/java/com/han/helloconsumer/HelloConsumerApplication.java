package com.han.helloconsumer;

import com.han.helloconsumer.config.AlwaysSampler;
import com.han.helloconsumer.config.RibboConfig;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RibbonClient(name = "hello-consumer" ,configuration = RibboConfig.class)
@SpringBootApplication
public class HelloConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloConsumerApplication.class, args);
	}

//	@Bean
//	public AlwaysSampler alwaysSampler() {
//		return new AlwaysSampler();
//	}
}
