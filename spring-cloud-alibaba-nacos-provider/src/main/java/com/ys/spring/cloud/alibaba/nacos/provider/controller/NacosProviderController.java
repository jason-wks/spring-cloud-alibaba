package com.ys.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 10:50
 * @version: 1.0.0
 */
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable(value = "message") String message){
        return "This is nacos test message :" + message + ",service prot " + port;
    }

    //yaml中自定义参数需要用以下方法
    @GetMapping("hi")
    public String hi(){
        return applicationContext.getEnvironment().getProperty("user.name");
    }
}
