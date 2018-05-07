package com.microservice.fallback;

import com.microservice.model.User;
import com.microservice.feignApi.HelloBackgroundService;
import org.springframework.stereotype.Component;

/**
 * @author : Cheese
 * @date : 2018/5/4
 * @description : TODO
 */
@Component
public class Tsetfallback implements HelloBackgroundService {
    @Override
    public String hello(String name){
        return "sorry, "+name+"访问 SERVICE-HELLO服务 出错";
    }

    @Override
    public User hello(String name, Integer age) {
        return null;
    }

    @Override
    public String hello(User user) {
        return "sorry, "+user.getName()+"访问 SERVICE-HELLO服务 出错";
    }
}
