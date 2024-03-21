package com.springboot.di.app.springbootdi.service;

import java.util.List;

import com.springboot.di.app.springbootdi.models.Product;

public interface ProductService {
    public List<Product> findAll();

    public Product findById(Long id);
}
