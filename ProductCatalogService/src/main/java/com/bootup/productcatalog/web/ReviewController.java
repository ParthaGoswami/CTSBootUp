package com.bootup.productcatalog.web;

import com.bootup.productcatalog.model.Review;
import com.bootup.productcatalog.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/products/{productId}/reviews")
    public ResponseEntity getProductsWithReviews(@PathVariable Integer productId) {
        return reviewService.getReviewsOfProducts(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.unprocessableEntity().build());
    }

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity addReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {
        return reviewService.addReview(productId, review)
                .map(p -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(p))
                .orElse(ResponseEntity.unprocessableEntity().build());
    }


}
