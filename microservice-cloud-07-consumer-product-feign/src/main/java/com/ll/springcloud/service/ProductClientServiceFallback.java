package com.ll.springcloud.service;


import com.ll.springcloud.entities.Product;

import java.util.List;

//fallback 作用，指定熔断处理类，如果被调用的方法处理异常，就会交给熔断处理类中的方法进行处理
public class ProductClientServiceFallback implements ProductClientService{


    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
