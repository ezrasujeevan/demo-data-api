package com.example.demodataapi.service.impl;

import com.example.demodataapi.entity.Product;
import com.example.demodataapi.repository.ProductRepo;
import com.example.demodataapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * @param id
     * @return
     */
    public Optional<Product> findOneById(String id) {
        return this.productRepo.findById(id);
    }

    /**
     * @return
     */
    public List<Product> FindAll() {
        return this.productRepo.findAll();
    }

    /**
     * @param product
     * @return
     */
    public Product create(Product product) {
        return this.productRepo.save(product);
    }

    /**
     * @param product
     * @return
     */
    public Product update(Product product) {
        return this.productRepo.save(product);
    }

    /**
     * @param id
     * @return
     */
    public Optional<Product> delete(String id) {
        Optional<Product> product = this.productRepo.findById(id);
        this.productRepo.deleteById(id);
        return product;
    }
}
