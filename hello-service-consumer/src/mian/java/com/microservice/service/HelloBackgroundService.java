package com.microservice.service;

import com.microservice.remote.api.HelloServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
@FeignClient(value = "hello-service-provider")
public interface HelloBackgroundService extends HelloServiceRemoteApi{
}
