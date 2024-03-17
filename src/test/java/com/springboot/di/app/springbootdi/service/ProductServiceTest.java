package com.springboot.di.app.springbootdi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.springboot.di.app.springbootdi.models.Product;

public class ProductServiceTest {

    private ProductService productService = new ProductService();

    @Test
    public void findAllTest(){
        List<Product> myList = Arrays.asList(
            new Product(1L, "Macbook 2020", 29000L),
            new Product(2L, "Iphone 2024", 31320L),
            new Product(3L, "AirPods 2020", 116L)
        );

        List<Product> listTest = productService.findAll();

        assertEquals(myList, listTest);
    }

    @Test
    public void findById(){
        Product productService = this.productService.findById(1L);
        Product test = new Product(1L, "Macbook 2020", 25000L);
        
        assertEquals(productService, test);
    }
}

