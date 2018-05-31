package com.microservice;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Cheese
 * @date : 2018/5/31
 * @description : TODO
 */
@Reference
@RestController
public class TestController {
    @Value("${from}")
    private String from;
    @RequestMapping("/from")
    public String from(){
        return this.from;
    }
}
