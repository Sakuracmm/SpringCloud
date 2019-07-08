package com.ll.springcloud.service;

import com.ll.springcloud.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "microservice-product", fallback = ProductClientServiceFallback.class)    //指定调用的微服务名称
public interface ProductClientService {

    @GetMapping(value = "/product/get/{id}")
    Product get(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/product/list")
    List<Product> list();

    @PostMapping(value = "/product/add")
    boolean add(@RequestBody Product product);



}
