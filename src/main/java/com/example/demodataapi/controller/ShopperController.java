package com.example.demodataapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/shopper")
public class ShopperController {

    @RequestMapping()
    public String Main()
    {
        return "Shopper Controller";
    }
}
