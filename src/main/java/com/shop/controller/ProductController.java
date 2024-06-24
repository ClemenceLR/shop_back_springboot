package com.shop.controller;

import com.shop.dao.Product;
import com.shop.manager.ProductManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductManager productManager;

    @Autowired
    public ProductController(ProductManager productManager) {
        this.productManager = productManager;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        log.info("[ProductController] Retrieving all products");
        return this.productManager.retrieveAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        log.info("[ProductController] Get a product by id = {}", id);
        return this.productManager.retrieveProductById(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product partialProduct) {
        log.info("[ProductController] Update product {}", id);
        return this.productManager.updateProduct(id,partialProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        log.info("[ProductController] Delete product {}", id);
        this.productManager.deleteProduct(id);
    }

    @PostMapping()
    public void createProduct(@RequestBody Product product) {
        log.info("[ProductController] Create product {}", product);
        this.productManager.createProduct(product);
    }

}
