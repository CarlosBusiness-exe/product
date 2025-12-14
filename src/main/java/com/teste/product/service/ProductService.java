package com.teste.product.service;

import com.teste.product.entity.Product;
import com.teste.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found id: " + id));
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public Product update(Product productUpdate, Long id){
        Product product = findById(id);
        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setQtd(productUpdate.getQtd());
        return save(product);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
