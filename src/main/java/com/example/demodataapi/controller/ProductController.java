package com.example.demodataapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/product")
public class ProductController {

    @RequestMapping()
    public String Main()
    {
        return "Product Controller";
    }
}
