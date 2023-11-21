package com.example.demodataapi.service;

import com.example.demodataapi.entity.Product;
import com.example.demodataapi.entity.ProductShopperScore;
import com.example.demodataapi.entity.Shopper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ScoreService {

    Optional<ProductShopperScore> findOneById(ProductShopperScore.ProductShopperScoreId id);

    Optional<ProductShopperScore> findOneById(String product_id, String shopper_id);

    Optional<ProductShopperScore> findOneById(Product product, Shopper shopper);

    List<ProductShopperScore> FindAll();

    List<ProductShopperScore> FindAllByShopper(String id);

    List<ProductShopperScore> FindAllByShopper(Shopper shopper);

    List<ProductShopperScore> FindAllByProduct(String id);

    List<ProductShopperScore> FindAllByProduct(Product product);

    ProductShopperScore create(ProductShopperScore score);

    List<ProductShopperScore> create(List<?> shoppers, Product product, long score);

    List<ProductShopperScore> create(List<?> products, Shopper shopper, long score);
}
