package com.microservice.feignApi;

import com.microservice.fallback.Tsetfallback;
import com.microservice.api.HelloServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @description TODO  
 *   
 * @author Cheese  
 * @date 2018/4/26
 * @param   
 * @return   
 */
@FeignClient(name = "hello-service-provider",fallback = Tsetfallback.class)
public interface HelloBackgroundService extends HelloServiceRemoteApi{
}
