package com.app.inventario.service;

import com.app.inventario.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product update(Product product);
    Boolean delete(Long id);
    Product getProductById(Long id);
}
