package com.bootup.productcatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Integer reviewId;
    @Column
    private Integer stars;
    @Column
    private String author;
    @Column
    private String body;
    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

}