package com.ll.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @LoadBalanced       //实现负载均衡，ip可以变成服务名称，服务名称就是被调用的那个服务名称（application.yml中配置的spring.application.name = ）
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
