package com.example.demodataapi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {


    @RequestMapping()
    public String Main() {
        return "Main Controller";
    }
}
