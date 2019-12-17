package com.ys.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;

import com.ys.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.stereotype.Component;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/13 14:16
 * @version: 1.0.0
 */
@Component
public class NacosProviderFallback implements NacosProviderService {
    @Override
    public String echo(String message) {
        return "请求失败，请检查您的网络";
    }
}
