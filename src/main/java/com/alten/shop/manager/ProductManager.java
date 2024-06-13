package com.alten.shop.manager;

import com.alten.shop.dao.Product;
import com.alten.shop.exceptions.ObjectNotFoundException;
import com.alten.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveAllProducts(){
        return this.productRepository.findAll();
    }

    public Product retrieveProductById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
    }
}
