package com.han.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Configuration;

@EnableAdminServer
@SpringCloudApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);

    }

//    @Configuration
//    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().anyRequest().permitAll()
//                    .and().csrf().disable();
//        }
//    }

}


