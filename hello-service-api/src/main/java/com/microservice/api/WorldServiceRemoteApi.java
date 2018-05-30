package com.microservice.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Cheese
 * @date : 2018/5/7
 * @description : TODO
 */
public interface WorldServiceRemoteApi {
    @RequestMapping(value = "/hello-service-remote/world", method = RequestMethod.GET)
    String world(@RequestParam("name") String name);
    @RequestMapping(value = "/hello-service-remote/world2", method = RequestMethod.GET)
    String world2(@RequestParam("name") String name) throws InterruptedException;
    @RequestMapping(value = "/hello-service-remote/world3", method = RequestMethod.GET)
    String world3(@RequestParam("name") String name) throws Exception;
}
