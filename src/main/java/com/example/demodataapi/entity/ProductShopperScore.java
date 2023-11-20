package com.example.demodataapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table
@Entity
public class ProductShopperScore implements Serializable {

    @EmbeddedId
    private ProductShopperScoreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopperId")
    private Shopper shopper;

    private double score;

    public ProductShopperScore(Product product, Shopper shopper) {
        this.product = product;
        this.shopper = shopper;
        this.id = new ProductShopperScoreId(product.getId(), shopper.getId());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @Embeddable
    public static class ProductShopperScoreId implements Serializable {
        private String productId;
        private String shopperId;
    }

}


