package com.example.demodataapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Product {

    @Id
    private String id;
    private String name;
    private String brand;
    private String category;

    @OneToMany(
            mappedBy = "tag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductShopperScore> ProductShopperScore = new ArrayList<>();

    public Product(String name, String brand, String category) {
        this.name = name;
        this.brand = brand;
        this.category = category;
    }
}
