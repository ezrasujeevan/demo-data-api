package com.example.demodataapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(schema = "spring")
@Entity
public class ProductShopperScore implements Serializable {

    @EmbeddedId
    private ProductShopperScoreId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("shopperId")
    @JoinColumn(name = "shopper_id")
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
        @Column(name = "product_id")
        private String productId;
        @Column(name = "shopper_id")
        private String shopperId;
    }

}


