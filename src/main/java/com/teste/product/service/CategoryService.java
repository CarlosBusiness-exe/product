package com.teste.product.service;

import com.teste.product.entity.Category;
import com.teste.product.repository.CategoryRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findall(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found id: " + id));
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category categoryUpdate, Long id) {
        Category  category = findById(id);
        category.setName(categoryUpdate.getName());
        return save(category);
    }

    public  void delete(Long id){
        findById(id);
        categoryRepository.deleteById(id);
    }
}
