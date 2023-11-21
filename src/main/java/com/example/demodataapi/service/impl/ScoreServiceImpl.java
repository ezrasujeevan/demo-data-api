package com.example.demodataapi.service.impl;

import com.example.demodataapi.entity.Product;
import com.example.demodataapi.entity.ProductShopperScore;
import com.example.demodataapi.entity.Shopper;
import com.example.demodataapi.repository.ProductShopperScoreRepo;
import com.example.demodataapi.service.ProductService;
import com.example.demodataapi.service.ScoreService;
import com.example.demodataapi.service.ShopperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ScoreServiceImpl implements ScoreService {

    private final ProductShopperScoreRepo scoreRepo;
    private final ShopperService shopperService;
    private final ProductService productService;

    public ScoreServiceImpl(ProductShopperScoreRepo scoreRepo, ShopperService shopperService, ProductService productService) {
        this.scoreRepo = scoreRepo;
        this.shopperService = shopperService;
        this.productService = productService;
    }


    /**
     * @param id
     * @return
     */
    @Override
    public Optional<ProductShopperScore> findOneById(ProductShopperScore.ProductShopperScoreId id) {
        return this.scoreRepo.findById(id);
    }

    /**
     * @param product_id
     * @param shopper_id
     * @return
     */
    @Override
    public Optional<ProductShopperScore> findOneById(String product_id, String shopper_id) {
        return this.scoreRepo.FindByIdProductAndIdShopper(product_id, shopper_id);
    }

    /**
     * @param product
     * @param shopper
     * @return
     */
    @Override
    public Optional<ProductShopperScore> findOneById(Product product, Shopper shopper) {
        return this.scoreRepo.FindByIdProductAndIdShopper(product.getId(), shopper.getId());
    }

    /**
     * @return
     */
    @Override
    public List<ProductShopperScore> FindAll() {
        return this.scoreRepo.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<ProductShopperScore> FindAllByShopper(String id, int limit, Optional<String> brand, Optional<String> category) {
        if (brand.isPresent() && category.isPresent()) {
            return this.scoreRepo.FindAllByIdShopper(id, limit, brand.get(), category.get());
        } else {
            if (brand.isPresent()) {
                return this.scoreRepo.FindAllByIdShopperBrand(id, limit, brand.get());
            } else if (category.isPresent()) {
//                return this.scoreRepo.FindAllByIdShopperCategory(id, limit, category.get());
                return null;
            }

        }
        return this.scoreRepo.FindAllByIdShopper(id, limit);

    }

    /**
     * @param shopper
     * @return
     */
    @Override
    public List<ProductShopperScore> FindAllByShopper(Shopper shopper, int limit, Optional<String> brand, Optional<String> category) {
        return this.scoreRepo.FindAllByIdShopper(shopper.getId(), limit);
//        return null;
    }


    /**
     * @param id
     * @return
     */
    @Override
    public List<ProductShopperScore> FindAllByProduct(String id, int limit) {
        return this.scoreRepo.FindAllByIdProduct(id, limit);
    }

    /**
     * @param product
     * @return
     */
    @Override
    public List<ProductShopperScore> FindAllByProduct(Product product, int limit) {
        return this.scoreRepo.FindAllByIdProduct(product.getId(), limit);
//        return null;
    }

    /**
     * @param score
     * @return
     */
    @Override
    public ProductShopperScore create(ProductShopperScore score) {
        return this.scoreRepo.save(score);
    }

    /**
     * @param shoppers
     * @param product
     * @param score
     * @return
     */
    @Override
    public List<ProductShopperScore> create(List<?> shoppers, Product product, long score) {
        List<ProductShopperScore> scores = new ArrayList<>();
        for (Object shopper : shoppers) {
            ProductShopperScore shopperScore;
            if (shopper instanceof String) {
                Shopper newShopper = this.shopperService.findOneById((String) shopper).get();
                shopperScore = new ProductShopperScore(product, newShopper);
                shopperScore.setScore(score);
                scores.add(shopperScore);

            } else if (shopper instanceof Shopper) {
                shopperScore = new ProductShopperScore(product, (Shopper) shopper);
                shopperScore.setScore(score);
                scores.add(shopperScore);
            }

        }

        return this.scoreRepo.saveAll(scores);
    }

    /**
     * @param products
     * @param shopper
     * @param score
     * @return
     */
    @Override
    public List<ProductShopperScore> create(List<?> products, Shopper shopper, long score) {
        List<ProductShopperScore> scores = new ArrayList<>();
        for (Object product : products) {
            ProductShopperScore productScore;
            if (product instanceof String) {
                Product newProduct = this.productService.findOneById((String) product).get();
                productScore = new ProductShopperScore(newProduct, shopper);
                productScore.setScore(score);
                scores.add(productScore);
            } else if (product instanceof Product) {
                productScore = new ProductShopperScore((Product) product, shopper);
                productScore.setScore(score);
                scores.add(productScore);
            }

        }
        return this.scoreRepo.saveAll(scores);
    }


}
