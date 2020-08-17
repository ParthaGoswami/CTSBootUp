package com.bootup.productcatalog.repository;

import com.bootup.productcatalog.model.Product;
import com.bootup.productcatalog.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByProduct(Product product);
}
