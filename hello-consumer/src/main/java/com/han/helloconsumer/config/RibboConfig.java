package com.han.helloconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibboConfig {

    @Bean
    IRule myRibbonRule(){
        return new WeightedResponseTimeRule();
    }
}
