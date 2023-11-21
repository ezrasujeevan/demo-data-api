package com.example.demodataapi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(schema = "spring")
public class Product {

    @Id
    private String id;
    private String name;
    private String brand;
    private String category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductShopperScore> ProductShopperScore = new HashSet<>();

    public Product(String name, String brand, String category) {
        this.name = name;
        this.brand = brand;
        this.category = category;
    }
}
