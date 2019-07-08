package com.ll.springcloud.controller;

import com.ll.springcloud.entities.Product;
import com.ll.springcloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //fallbackMethod指定当get方法出现异常的时候，将要调用并进行处理的方法
    //处理方法返回值与参数类型要一致
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping(value = "/product/get/{id}")
    public Product get(@PathVariable(value = "id") Long id){
        Product product =  productService.get(id);
        //如果product为空，模拟一个异常
        if (product == null){
            throw new RuntimeException("id = " + id + " 无效 ！");
        }
        return product;
}

    @GetMapping(value = "/product/list")
    public List<Product> list(){
        return productService.list();
    }

    @PostMapping(value = "/product/add")
    public boolean add(@RequestBody Product product){
        return productService.add(product);
    }

    public Product getFallback(@PathVariable(value = "id") Long id){
        return new Product(id,"ID " + id + "无效！",
                "无法找到对应的数据库进行处理......");
    }

}
