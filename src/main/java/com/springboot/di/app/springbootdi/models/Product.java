package com.springboot.di.app.springbootdi.models;

public class Product {
    private Long id;
    private String name;
    private Long price;

    public Product(Long id, String name, Long price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        Product newProduct = (Product) obj;

        return newProduct.getId().equals(this.getId()) && newProduct.getName().equals(this.getName())
            && newProduct.getPrice().equals(this.getPrice());

    }
    
}
