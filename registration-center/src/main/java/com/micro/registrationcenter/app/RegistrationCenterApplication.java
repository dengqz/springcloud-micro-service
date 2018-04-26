package com.micro.registrationcenter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : Cheese
 * @date : 2018/4/26
 * @description : TODO
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationCenterApplication.class, args);
    }
}
