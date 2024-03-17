package com.springboot.di.app.springbootdi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.di.app.springbootdi.models.Product;
import com.springboot.di.app.springbootdi.repositories.ProductRepository;


public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll(){
        return this.productRepository.findAll().stream().map(p -> {
            Double priceWithIva = (p.getPrice() * 0.16d) + p.getPrice();
            p.setPrice(priceWithIva.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return this.productRepository.findById(id);
    }
}
