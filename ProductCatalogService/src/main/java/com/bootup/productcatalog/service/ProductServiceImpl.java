package com.bootup.productcatalog.service;

import com.bootup.productcatalog.model.Product;
import com.bootup.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<List<Product>> getAllProducts() {
        return Optional.ofNullable(productRepository.findAll());
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> getProductByProductName(String productName) {
        return Optional.ofNullable(productRepository.findByNameContaining(productName));
    }

    @Override
    public Optional<Product> addProduct(Product product) {
        return Optional.ofNullable(productRepository.save(product));
    }

    @Override
    public Optional<List<Product>> addAllProduct(List<Product> products) {
        return Optional.ofNullable(productRepository.saveAll(products));
    }
}
