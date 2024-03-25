package com.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.di.app.springbootdi.models.Product;
import com.springboot.di.app.springbootdi.service.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    private final ProductService productService;

    public SomeController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return productService.findById(id);
    }

}
