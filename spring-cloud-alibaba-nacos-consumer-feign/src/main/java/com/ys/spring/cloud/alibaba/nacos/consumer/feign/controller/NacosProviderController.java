package com.ys.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.ys.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 11:49
 * @version: 1.0.0
 */
@RestController
public class NacosProviderController {

    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping("/echo")
    public String echo(){
        return nacosProviderService.echo("nacos is feign");
    }
}
