package com.bootA.ecom_server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bootA.ecom_server.models.Product;
import com.bootA.ecom_server.repos.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepo productRepo;
    
    // GET all
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // POST add
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product newProduct) {
        return productRepo.save(newProduct);
    }

    // PUT update
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productRepo.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    return productRepo.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
