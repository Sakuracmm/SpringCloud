package com.ll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer_5001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_5001.class,args);
    }
}
