package com.springboot.di.app.springbootdi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.di.app.springbootdi.models.Product;
import com.springboot.di.app.springbootdi.repositories.ProductRepository;

import io.vavr.control.Try;

@Service
public class ProductServiceImpl implements ProductService{
    
    private ProductRepository productRepository;

    public ProductServiceImpl(@Qualifier("jsonRepository") ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Autowired
    private Environment environment;

    @Override
    public List<Product> findAll(){
        // Solve Immutability problem: Increment in the price (are singleton they will have that change)
        return this.productRepository.findAll().stream()
                .map((p) -> modifiedProduct(p))
                .collect(Collectors.toList());

    }

    private Product modifiedProduct(Product p) {
        Double priceWithIva = catchNullInTaxPrice(p) + p.getPrice();

        Product product = (Product) p.clone(); 
        product.setPrice(priceWithIva.longValue());

        return product;
    }

    private Double catchNullInTaxPrice(Product p){
        return Try.of(() -> p.getPrice() * Double.parseDouble(environment.getProperty("config.price.tax"))).get();
    }

    @Override
    public Product findById(Long id){
        return this.productRepository.findById(id);
    }
}
