package com.bootup.productcatalog.web;

import com.bootup.productcatalog.model.Product;
import com.bootup.productcatalog.service.ProductService;
import com.bootup.productcatalog.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    private ProductService productService;
    private ReviewService reviewService;

    public ProductController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.of((productService.getAllProducts()));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.of(productService.getProduct(id));
    }

    @GetMapping("/products/byName/{name}")
    public ResponseEntity<List<Product>> getProductByProductName(@PathVariable("name") String productName) {
        return ResponseEntity.of(productService.getProductByProductName(productName));
    }

    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product product) {
        return productService.addProduct(product).map(p -> ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(product.getId()).toUri())
                .body(p)
        ).orElse(ResponseEntity.unprocessableEntity().build());
    }

    @PostMapping("/products/all")
    public ResponseEntity addAllProducts(@RequestBody List<Product> products) {
        return productService.addAllProduct(products)
                .map(p -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(p))
                .orElse(ResponseEntity.unprocessableEntity().build());
    }

}
