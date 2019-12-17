package com.ys.spring.cloud.alibaba.nacos.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 11:14
 * @version: 1.0.0
 */
@Configuration
public class NacosConsumerConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
