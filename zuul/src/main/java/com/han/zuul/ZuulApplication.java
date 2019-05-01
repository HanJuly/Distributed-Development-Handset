package com.han.zuul;

import com.han.zuul.fitler.AccessFilter;
import com.han.zuul.fitler.PostErrorFilter;
import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Bean
	ZuulFilter getAccessFilter(){
		return new AccessFilter();
	}



	@Bean
	ZuulFilter getPostErrorFilter(){
		return new PostErrorFilter();
	}
}
