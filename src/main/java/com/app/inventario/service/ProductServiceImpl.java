package com.app.inventario.service;

import com.app.inventario.model.Product;
import com.app.inventario.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {

        List<Product> products= productRepository.findAll();
        List<Product> productosActivos= products.stream()
                .filter(product -> product.getState())
                .collect(Collectors.toList());
        return productosActivos;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if(!productRepository.existsById(product.getProductId())) {
            return null;
        }
        return productRepository.save(product);
    }

    @Override
    public Boolean delete(Long id) {
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
