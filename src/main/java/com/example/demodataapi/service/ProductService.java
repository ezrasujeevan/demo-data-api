package com.example.demodataapi.service;

import com.example.demodataapi.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Optional<Product> findOneById(String id);
    List<Product> FindAll();
    Product create(Product product);

    Product update(Product product);

    Optional<Product> delete(String id);
}
