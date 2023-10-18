package com.app.inventario.service;

import com.app.inventario.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getCategoryById(Long categoryId);
}
