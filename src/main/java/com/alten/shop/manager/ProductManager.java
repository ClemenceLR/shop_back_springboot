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

    @Autowired
    private ProductMapper mapper;

    public List<Product> retrieveAllProducts(){
        return this.productRepository.findAll();
    }

    public Product retrieveProductById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
    }

    public Product updateProduct(Long id, Product productToPatch) {
        Product existingProduct = this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
        mapper.updateProductFromDto(productToPatch, existingProduct);
        this.productRepository.save(existingProduct);
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
