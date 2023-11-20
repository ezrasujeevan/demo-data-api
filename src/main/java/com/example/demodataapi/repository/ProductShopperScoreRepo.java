package com.example.demodataapi.repository;

import com.example.demodataapi.entity.ProductShopperScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductShopperScoreRepo extends JpaRepository<ProductShopperScore, ProductShopperScore.ProductShopperScoreId> {
}
