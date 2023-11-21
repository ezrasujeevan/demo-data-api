package com.example.demodataapi.service;

import com.example.demodataapi.entity.Shopper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ShopperService {

    Optional<Shopper> findOneById(String id);

    List<Shopper> FindAll();

    Shopper create(Shopper shopper);

    Shopper update(Shopper shopper);

    Optional<Shopper> delete(String id);
}
