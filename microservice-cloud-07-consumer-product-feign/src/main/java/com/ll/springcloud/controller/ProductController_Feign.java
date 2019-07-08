package com.ll.springcloud.controller;


import com.ll.springcloud.entities.Product;
import com.ll.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController_Feign {

    @Autowired
    ProductClientService productClientService;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product){
        return productClientService.add(product);
    }

    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id){
        return productClientService.get(id);
    }

    @RequestMapping(value = "/consumer/product/list")
    public List<Product> get(){
        return productClientService.list();
    }

}
