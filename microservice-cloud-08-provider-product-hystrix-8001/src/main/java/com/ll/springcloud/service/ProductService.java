package com.ll.springcloud.service;

import com.ll.springcloud.entities.Product;

import java.util.List;

public interface ProductService {

    boolean add(Product product);
    Product get(Long id);
    List<Product> list();


}
