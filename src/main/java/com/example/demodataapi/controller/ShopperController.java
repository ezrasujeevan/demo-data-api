package com.example.demodataapi.controller;

import com.example.demodataapi.service.ShopperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/shopper")
public class ShopperController {

    private final ShopperService shopperService;

    public ShopperController(ShopperService shopperService) {
        this.shopperService = shopperService;
    }

    @RequestMapping()
    public String Main()
    {
        return "Shopper Controller";
    }
}
