package com.ll.springcloud.controller;

import com.ll.springcloud.entities.Product;
import com.ll.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/get/{id}")
    public Product get(@PathVariable(value = "id") Long id){
        return productService.get(id);
    }

    @GetMapping(value = "/product/list")
    public List<Product> list(){
        return productService.list();
    }

    @PostMapping(value = "/product/add")
    public boolean add(@RequestBody Product product){
        return productService.add(product);
    }


}
