package com.microservice.api;

import com.microservice.model.User;
import org.springframework.web.bind.annotation.*;


/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
//@RequestMapping("/hello-service-remote")
public interface HelloServiceRemoteApi {

    @RequestMapping(value = "/hello-service-remote/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-service-remote/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);


    @RequestMapping(value = "/hello-service-remote/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
