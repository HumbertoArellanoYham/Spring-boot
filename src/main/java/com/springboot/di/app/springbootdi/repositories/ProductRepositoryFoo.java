package com.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.springboot.di.app.springbootdi.models.Product;

@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Apple Vision Pro", 3500L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Apple Vision Pro", 3500L);
    }

}
