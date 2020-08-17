package com.bootup.productcatalog.service;

import com.bootup.productcatalog.model.Product;
import com.bootup.productcatalog.model.Review;
import com.bootup.productcatalog.repository.ProductRepository;
import com.bootup.productcatalog.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Review> addReview(Integer productId, Review review) {
        Product product = productRepository.findById(productId)
                .orElseThrow();
        review.setProduct(product);
        return Optional.ofNullable(reviewRepository.save(review));
    }

    @Override
    public Optional<List<Review>> getReviewsOfProducts(Integer productId) {
        Product product = new Product();
        product.setId(productId);
        return Optional.ofNullable(reviewRepository.findByProduct(product));
    }
}
