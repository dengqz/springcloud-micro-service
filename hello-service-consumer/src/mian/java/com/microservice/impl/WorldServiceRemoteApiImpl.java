package com.microservice.impl;

import com.microservice.api.WorldServiceRemoteApi;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Cheese
 * @date : 2018/5/7
 * @description : TODO
 */
@RestController
public class WorldServiceRemoteApiImpl implements WorldServiceRemoteApi {
    @Override
    public String world(@RequestParam("name") String name) {
        System.out.println("111");
        return "world " + name;
    }

    @Override
    public String world2(String name) throws InterruptedException {
        Thread.sleep(10000);
        return "world2 " + name;
    }

    @Override
    public String world3(String name) throws RuntimeException {
        return "world3 " + name;
    }
}
