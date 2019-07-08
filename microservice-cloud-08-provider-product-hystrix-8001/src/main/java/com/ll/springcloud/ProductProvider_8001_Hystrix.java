package com.ll.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient     //将此服务注册到Eureka服务注册中心
@MapperScan(value = "com.ll.springcloud.mapper")
@SpringBootApplication
@EnableHystrix      //开启Hytrix的熔断机制
public class ProductProvider_8001_Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8001_Hystrix.class,args);
    }

}
