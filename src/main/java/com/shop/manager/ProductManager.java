package com.shop.manager;

import com.shop.dao.Product;
import com.shop.exceptions.ObjectNotFoundException;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductManager(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<Product> retrieveAllProducts(){
        return this.productRepository.findAll();
    }

    public Product retrieveProductById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
    }

    public Product updateProduct(Long id, Product partialProduct) {
        Product existingProduct = this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
        mapper.updateProductFromDto(partialProduct, existingProduct);
        this.productRepository.save(existingProduct);
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }
}
