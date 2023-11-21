package com.example.demodataapi.service;

import com.example.demodataapi.entity.Product;
import com.example.demodataapi.entity.ProductShopperScore;
import com.example.demodataapi.entity.Shopper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ScoreService {

    Optional<ProductShopperScore> findOneById(ProductShopperScore.ProductShopperScoreId id);

    Optional<ProductShopperScore> findOneById(String product_id, String shopper_id);

    Optional<ProductShopperScore> findOneById(Product product, Shopper shopper);

    List<ProductShopperScore> FindAll();

    List<ProductShopperScore> FindAllByShopper(String id,int limit,Optional<String> brand, Optional<String> category);

    List<ProductShopperScore> FindAllByShopper(Shopper shopper,int limit,Optional<String> brand, Optional<String> category);

    List<ProductShopperScore> FindAllByProduct(String id,int limit);

    List<ProductShopperScore> FindAllByProduct(Product product,int limit);

    ProductShopperScore create(ProductShopperScore score);

    List<ProductShopperScore> create(List<?> shoppers, Product product, long score);

    List<ProductShopperScore> create(List<?> products, Shopper shopper, long score);
}
