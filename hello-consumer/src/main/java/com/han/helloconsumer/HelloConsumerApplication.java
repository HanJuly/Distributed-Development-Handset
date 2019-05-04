package com.han.helloconsumer;

import com.han.helloconsumer.config.RibboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RibbonClient(name = "hello-consumer" ,configuration = RibboConfig.class)
@SpringBootApplication(scanBasePackages={"com.han.helloconsumer","com.hw.common"})
public class HelloConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloConsumerApplication.class, args);
	}

}
