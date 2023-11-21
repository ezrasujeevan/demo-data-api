package com.example.demodataapi.service.impl;

import com.example.demodataapi.entity.Shopper;
import com.example.demodataapi.repository.ShopperRepo;
import com.example.demodataapi.service.ShopperService;

import java.util.List;
import java.util.Optional;

public class ShopperServiceImpl implements ShopperService {

    private final ShopperRepo shopperRepo;

    public ShopperServiceImpl(ShopperRepo shopperRepo) {
        this.shopperRepo = shopperRepo;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Shopper> findOneById(String id) {
        return this.shopperRepo.findById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Shopper> FindAll() {
        return this.shopperRepo.findAll();
    }

    /**
     * @param shopper
     * @return
     */
    @Override
    public Shopper create(Shopper shopper) {
        return this.shopperRepo.save(shopper);
    }

    /**
     * @param shopper
     * @return
     */
    @Override
    public Shopper update(Shopper shopper) {
        return this.shopperRepo.save(shopper);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Shopper> delete(String id) {
        Optional<Shopper> shopper = this.shopperRepo.findById(id);
        this.shopperRepo.deleteById(id);
        return shopper;
    }
}
