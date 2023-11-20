package com.example.demodataapi.controller;


import com.example.demodataapi.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping()
    public String Main() {
        return "hello";
    }
}
