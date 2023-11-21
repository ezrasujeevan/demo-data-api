package com.example.demodataapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "spring")
public class Shopper {

    @Id
    private String id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopper")
    private Set<ProductShopperScore> productShopperScores = new HashSet<>();

    public Shopper(String name) {
        this.name = name;
    }

    public void addProductScore(Product product, double score) {
        ProductShopperScore newproductShopperScore = new ProductShopperScore(product, this);
        newproductShopperScore.setScore(score);
        productShopperScores.add(newproductShopperScore);
        product.getProductShopperScore().add(newproductShopperScore);

    }

    public void removeProductScore(Product product) {
        for (Iterator<ProductShopperScore> iterator = productShopperScores.iterator(); iterator.hasNext(); ) {
            ProductShopperScore productShopperScore = iterator.next();

            if (productShopperScore.getShopper().equals(this) && productShopperScore.getProduct().equals(product)) {
                iterator.remove();
                productShopperScore.getProduct().getProductShopperScore().remove(productShopperScore);
                productShopperScore.setProduct(null);
                productShopperScore.setShopper(null);
            }
        }

    }
}
