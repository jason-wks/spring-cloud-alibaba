package com.ys.spring.cloud.alibaba.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 11:16
 * @version: 1.0.0
 */
@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appname;

    @GetMapping("/echo/app/name")
    public String echo(){
        ServiceInstance instance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s",instance.getHost(),instance.getPort(),appname);
        System.out.println("url=============>"  + url);
        return restTemplate.getForObject(url,String.class);
    }
}
