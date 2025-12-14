package com.teste.product.controller;

import com.teste.product.entity.Category;
import com.teste.product.entity.Product;
import com.teste.product.repository.CategoryRepository;
import com.teste.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findall(){
        return ResponseEntity.ok().body(service.findall());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.ok().body(service.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updte(@RequestBody Category category, @PathVariable Long id){
        return ResponseEntity.ok().body(service.update(category, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
