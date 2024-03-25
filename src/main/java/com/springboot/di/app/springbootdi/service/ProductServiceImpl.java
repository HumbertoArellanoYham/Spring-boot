package com.springboot.di.app.springbootdi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.di.app.springbootdi.models.Product;
import com.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    
    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(){
        // Solve Immutability problem: Increment in the price (are singleton they will have that change)
        return this.productRepository.findAll().stream().map(p -> {
            Double priceWithIva = (p.getPrice() * 0.16d) + p.getPrice();
            Product product = (Product) p.clone(); 
            product.setPrice(priceWithIva.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return this.productRepository.findById(id);
    }
}
