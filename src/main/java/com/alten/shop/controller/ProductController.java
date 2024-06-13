package com.alten.shop.controller;

import com.alten.shop.dao.Product;
import com.alten.shop.manager.ProductManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductManager productManager;
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


}
