package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//会扫描指定包下面的是使用@FeignClient标识的接口
@EnableFeignClients(basePackages = "com.ll.springcloud.service")
@EnableEurekaClient //标识是一个eureka客户端
@SpringBootApplication
public class ProductConsumer_80_FeignClient {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer_80_FeignClient.class,args);
    }

}
