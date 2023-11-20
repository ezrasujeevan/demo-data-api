package com.example.demodataapi.repository;

import com.example.demodataapi.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepo extends JpaRepository<Shopper,String> {
}
