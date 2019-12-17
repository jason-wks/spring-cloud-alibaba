package com.ys.spring.cloud.alibaba.nacos.consumer.feign.service;

import com.ys.spring.cloud.alibaba.nacos.consumer.feign.service.fallback.NacosProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 11:46
 * @version: 1.0.0
 */
@FeignClient(value = "nacos-provider",fallback = NacosProviderFallback.class)
public interface NacosProviderService {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable(value = "message") String message);
}
