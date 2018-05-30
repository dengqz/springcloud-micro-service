package com.microservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
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
    public String defaultFallback(Throwable throwable){
        throwable.printStackTrace();
        return "断路器开启，远程服务调用失败-world3";
    }

    @GetMapping("/world2")
    @HystrixCommand(fallbackMethod = "defaultFallback2")
    public String  world2(){
        return restTemplate.getForObject("http://hello-service-consumer/hello-service-remote/world2?name="+"world2",String.class);
    }
    public String defaultFallback2(Throwable throwable){
        throwable.printStackTrace();
        return "断路器开启，远程服务调用失败-world3 "+ throwable.getMessage();
    }
    @GetMapping("/world3")
    @HystrixCommand(fallbackMethod = "defaultFallback3")
    public String  world3(){
        return restTemplate.getForObject("http://hello-service-consumer/hello-service-remote/world3?name="+"world3",String.class);
    }
    public String defaultFallback3(Throwable throwable){
        throwable.printStackTrace();
        return "断路器开启，远程服务调用失败-world3 "+ throwable.getMessage();
    }
    @GetMapping("/world4")
    @CacheResult
    @HystrixCommand(fallbackMethod = "defaultFallback4",commandKey = "world4",groupKey = "world",threadPoolKey = "world4Thread")
    public String  world4(){
        throw new RuntimeException("exception");
    }
    public String defaultFallback4(Throwable throwable){
        throwable.printStackTrace();
        return "断路器开启，远程服务调用失败-world4 "+ throwable.getMessage();
    }

}
