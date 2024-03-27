package com.springboot.di.app.springbootdi.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource("classpath:config.properties")
})
public class AppConfig {

    @Bean
    @Qualifier("jsonRepository")
    ProductRepository jsonRepository(){
        return new ProductRepositoryJson();
    }
}
