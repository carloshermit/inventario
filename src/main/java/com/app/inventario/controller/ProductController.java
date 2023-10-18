package com.app.inventario.controller;

import com.app.inventario.model.Category;
import com.app.inventario.model.Product;
import com.app.inventario.model.Unit;
import com.app.inventario.service.CategoryService;
import com.app.inventario.service.ProductService;
import com.app.inventario.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private  final Logger log= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UnitService unitService;

    @GetMapping("/read")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products=productService.findAll();
        if(products.isEmpty())
            return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        Category category= categoryService.getCategoryById(product.getCategory().getCategoryId());
        Unit unit= unitService.getUnitById(product.getUnit().getUnitId());
        if (category == null || unit== null) {
            return ResponseEntity.badRequest().build();
        }
        product.setCategory(category);
        product.setUnit(unit);
        Product productNew= productService.save(product);
        return  ResponseEntity.ok(productNew);
    }
    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product productUpdate= productService.update(product);
        return  ResponseEntity.ok(productUpdate);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product=productService.getProductById(id);
        if(product==null)
            return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(product);
    }
}
