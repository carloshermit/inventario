package com.app.inventario.service;

import com.app.inventario.model.Category;
import com.app.inventario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
