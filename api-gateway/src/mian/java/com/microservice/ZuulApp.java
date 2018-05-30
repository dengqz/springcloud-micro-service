package com.microservice;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApp.class).web(true).run(args);
    }
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
