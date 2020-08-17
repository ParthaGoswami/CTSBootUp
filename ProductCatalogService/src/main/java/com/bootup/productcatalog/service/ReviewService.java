package com.bootup.productcatalog.service;

import com.bootup.productcatalog.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> addReview(Integer productId, Review review);

    Optional<List<Review>> getReviewsOfProducts(Integer productId);
}
