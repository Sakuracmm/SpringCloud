package com.ll.springcloud.service;


import com.ll.springcloud.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

//fallback 作用，指定熔断处理类，如果被调用的方法处理异常，就会交给熔断处理类中的方法进行处理
@Component      //一定要加上他，纳入容器中
public class ProductClientServiceFallback implements ProductClientService{

    @Override
    public Product get(Long id) {
        return new Product(id, "id = " + id + " 无数据！！！ @FeignClient & Hystrix !!","没有与之匹配的数据库信息！");
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
