package com.alten.shop.manager;

import com.alten.shop.dao.Product;
import com.alten.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveAllProducts(){
        return this.productRepository.findAll();
    }
}
