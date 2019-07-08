package com.ll.springcloud.mapper;

import com.ll.springcloud.entities.Product;

import java.util.List;

//@Mapper //或者在启动类上使用@MapperScan标识
public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);

}
