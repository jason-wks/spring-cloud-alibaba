package com.ys.spring.cloud.alibaba.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author ：Strong
 * @date ：Created in 2019/6/19 12:04
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableBinding({Sink.class})
public class RocketMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class,args);
    }


    @StreamListener("input")
    public void receiveInput(String receiveMessage){
        System.out.println("input receiver ==>" + receiveMessage);
    }
}
