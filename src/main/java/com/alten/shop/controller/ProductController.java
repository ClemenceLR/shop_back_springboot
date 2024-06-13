package com.alten.shop.controller;

import com.alten.shop.dao.Product;
import com.alten.shop.manager.ProductManager;
import com.alten.shop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductManager productManager;
    @GetMapping()
    public List<Product> getAllProducts(){
        log.info("Retrieving all products");
        List<Product> test = this.productManager.retrieveAllProducts();
        log.info(test.toString());
        return this.productManager.retrieveAllProducts();
    }
}
