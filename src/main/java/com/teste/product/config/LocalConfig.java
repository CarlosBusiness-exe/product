package com.teste.product.config;

import com.teste.product.entity.Product;
import com.teste.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LocalConfig {

    @Bean
    public CommandLineRunner mockDatabase(ProductRepository repository) {
        return args -> {
            Product productA = new Product(null, "Produto A", 50.0, 23);
            Product productB = new Product(null, "Produto B", 32.0, 34);
            Product productC = new Product(null, "Produto C", 34.0, 53);
            Product productD = new Product(null, "Produto D", 23.0, 75);
            repository.saveAll(List.of(productA, productB, productC, productD, productD));
        };
    }
}
