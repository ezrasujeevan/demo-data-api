package com.example.demodataapi.repository;

import com.example.demodataapi.entity.ProductShopperScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductShopperScoreRepo extends JpaRepository<ProductShopperScore, ProductShopperScore.ProductShopperScoreId> {


//    Optional<ProductShopperScore> FindByProductAndShopper(@Param("product")Product product, @Param("product")Shopper shopper);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id and  product.id = :product_id")
    Optional<ProductShopperScore> FindByIdProductAndIdShopper(@Param("product_id") String product_id, @Param("shopper_id") String shopper_id);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :product_id")
    List<ProductShopperScore> FindAllByIdProduct(@Param("product_id") String product_id);


    // List<ProductShopperScore> FindAllByProduct(Product product);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id")
    List<ProductShopperScore> FindAllByIdShopper(@Param("shopper_id") String shopper_id);

    //List<ProductShopperScore> FindAllByShopper(Shopper shopper);
}
