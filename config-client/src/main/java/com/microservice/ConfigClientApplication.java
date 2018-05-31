package com.microservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : Cheese
 * @date : 2018/5/31
 * @description : TODO
 */
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
