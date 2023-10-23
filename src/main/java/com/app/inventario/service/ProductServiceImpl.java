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
        return products;
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
    public String delete(Long id) {
        Product product=productRepository.findById(id).orElse(null);
        if(Objects.nonNull(product)){
            product.setState(false);
            productRepository.save(product);
            return "Producto Eliminado Correctamente";
        }
        return "Producto no se encuentra registrado";
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
