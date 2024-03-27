package com.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.di.app.springbootdi.models.Product;

import io.vavr.control.Try;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();

        transformJsonInListProducts(objectMapper, resource);
    }

    private void transformJsonInListProducts(ObjectMapper objectMapper, Resource resource) {
        Try.of(() -> Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)))
            .onFailure((e) -> e.getMessage())
            .onSuccess((l) -> list = l);
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter((p) -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
