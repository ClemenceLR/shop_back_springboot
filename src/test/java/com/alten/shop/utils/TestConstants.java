package com.alten.shop.utils;

import com.alten.shop.dao.Product;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static List<Product> getAllProducts() {
        Product product1 = getProduct();
        Product product2 = getProduct();
        product2.setId(2L);
        product2.setName("Patch");

        List<Product> productList = List.of(product1, product2);

        return productList;
    }

    public static Product getProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setCode("azerty");
        product.setName("Watch");
        product.setCategory("TECHNOLOGY");
        product.setPrice(100L);
        product.setDescription("Product description");
        product.setRating(4);
        product.setImage("/image");
        product.setQuantity(10);
        product.setInventoryStatus("IN STOCK");
        return product;
    }
}
