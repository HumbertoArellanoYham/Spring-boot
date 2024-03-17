package com.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.springboot.di.app.springbootdi.models.Product;

import io.vavr.control.Try;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L, "Macbook 2020", 25000L),
            new Product(2L, "Iphone 2024", 27000L),
            new Product(3L, "AirPods 2020", 100L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
