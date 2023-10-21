package com.app.inventario.controller;

import com.app.inventario.model.Category;
import com.app.inventario.model.Unit;
import com.app.inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/read")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categorys=categoryService.getAll();
        if(categorys.isEmpty())
            return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(categorys);
    }
}
