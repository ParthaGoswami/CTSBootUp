package com.bootup.productcatalog.service;

import com.bootup.productcatalog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAllProducts();

    Optional<Product> getProduct(Integer id);

    Optional<List<Product>> getProductByProductName(String productName);

    Optional<Product> addProduct(Product product);

    Optional<List<Product>> addAllProduct(List<Product> products);
}
