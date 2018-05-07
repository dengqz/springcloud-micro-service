package com.microservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Cheese
 * @date : 2018/5/7
 * @description : TODO
 */
@RestController
public class WorldController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/world")
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public String  world(){
        return restTemplate.getForObject("http://hello-service-consumer/hello-service-remote/world?name="+"world",String.class);
    }
    public String defaultFallback(){
        return "断路器开启，远程服务调用失败";
    }

    @GetMapping("/world2")
    @HystrixCommand(fallbackMethod = "defaultFallback2")
    public String  world2(){
        return restTemplate.getForObject("http://hello-service-consumer/hello-service-remote/world2?name="+"world2",String.class);
    }
    public String defaultFallback2(){
        return "断路器开启，远程服务调用失败";
    }

}
