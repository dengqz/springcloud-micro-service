package com.microservice;

import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author : Cheese
 * @date : 2018/5/3
 * @description : TODO
 */
public class FeignConfig {
    /**
     * 自定义重试次数
     * 重试间隔为100ms，最大重试时间为1s,重试次数为5次
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }
}
