package com.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.springboot.di.app.springbootdi.models.Product;

@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{
    
    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L, "Macbook 2020", 25000L),
            new Product(2L, "Iphone 2024", 27000L),
            new Product(3L, "AirPods 2020", 100L)
        );
    }

    @Override
    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
