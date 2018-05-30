package com.microservice.controller;

import com.microservice.model.User;
import com.microservice.feignApi.HelloBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    @RequestMapping(value = "/hello")
    public Map<String,Object> hello(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = helloBackgroundService.hello("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = helloBackgroundService.hello(new User("王五", 19));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }
    @RequestMapping(value = "/hello1")
    public String hello1(){
       return  helloBackgroundService.hello("张三");
    }

    @RequestMapping(value = "/hello2")
    public String hello2(){
        User user = null;
        try {
             user = helloBackgroundService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return user.toString();
    }
    @RequestMapping(value = "/hello3")
    public String hello3(){
        return helloBackgroundService.hello(new User("王五", 19));
    }

    @RequestMapping(value = "/ribbon")
    public void ribbonTest(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("hello-service-provider");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());
    }
}
