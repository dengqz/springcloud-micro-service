package com.microservice.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloProviderApplication.class, args);
    }
}
