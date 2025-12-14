package com.teste.product.config;


import com.teste.product.entity.Category;
import com.teste.product.entity.Product;
import com.teste.product.repository.CategoryRepository;
import com.teste.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LocalConfig {

    @Bean
    public CommandLineRunner mockDatabase(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {
            Category categoriaA = new Category(null, "Categoria A");
            Category categoriaB = new Category(null, "Categoria B");
            Category categoriaC = new Category(null, "Categoria C");
            Category categoriaD = new Category(null, "Categoria D");

            categoryRepository.saveAll(List.of(categoriaA, categoriaB, categoriaC, categoriaD));

            Product productA = new Product(null, "Produto A", 50.0, 20, categoriaA);
            Product productB = new Product(null, "Produto B", 500.0, 1, categoriaB);
            Product productC = new Product(null, "Produto C", 10.0, 3, categoriaC);
            Product productD = new Product(null, "Produto D", 20.0, 31, categoriaD);

            productRepository.saveAll(List.of(productA, productB, productC, productD));
        };
    }
}
