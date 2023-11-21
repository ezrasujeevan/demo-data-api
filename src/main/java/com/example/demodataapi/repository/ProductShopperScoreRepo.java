package com.example.demodataapi.repository;

import com.example.demodataapi.entity.ProductShopperScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductShopperScoreRepo extends JpaRepository<ProductShopperScore, ProductShopperScore.ProductShopperScoreId> {


//    Optional<ProductShopperScore> FindByProductAndShopper(@Param("product")Product product, @Param("product")Shopper shopper);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id and  product.id = :product_id")
    Optional<ProductShopperScore> FindByIdProductAndIdShopper(@Param("product_id") String product_id, @Param("shopper_id") String shopper_id);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :product_id limit:max")
    List<ProductShopperScore> FindAllByIdProduct(@Param("product_id") String product_id, @Param("max") int limit);


    // List<ProductShopperScore> FindAllByProduct(Product product);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id limit :max")
    List<ProductShopperScore> FindAllByIdShopper(@Param("shopper_id") String shopper_id, @Param("max") int limit);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id and product.brand = :brand and product.category = :category limit :max")
    List<ProductShopperScore> FindAllByIdShopper(@Param("shopper_id") String shopper_id, @Param("max") int limit, @Param("brand") String brand, @Param("category") String category);

    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id and product.brand = :brand limit :max")
    List<ProductShopperScore> FindAllByIdShopperBrand(@Param("shopper_id") String shopper_id, @Param("max") int limit, @Param("brand") String brand);

//    @Query("SELECT ProductShopperScore from ProductShopperScore WHERE shopper.id = :shopper_id and product.category = :category limit :max")
//    List<ProductShopperScore> FindAllByIdShopperCategory(@Param("shopper_id") String shopper_id, @Param("max") int limit, @Param("category") String category);

    //List<ProductShopperScore> FindAllByShopper(Shopper shopper);
}
