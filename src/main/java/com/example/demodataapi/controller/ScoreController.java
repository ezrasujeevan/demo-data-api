package com.example.demodataapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/score")
public class ScoreController {

    @RequestMapping()
    public String Main()
    {
        return "Score Controller";
    }
}
