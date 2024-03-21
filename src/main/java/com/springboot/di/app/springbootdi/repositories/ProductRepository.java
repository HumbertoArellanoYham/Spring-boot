package com.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.springboot.di.app.springbootdi.models.Product;

public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(Long id);
}
