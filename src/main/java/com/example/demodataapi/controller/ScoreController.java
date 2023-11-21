package com.example.demodataapi.controller;

import com.example.demodataapi.entity.ProductShopperScore;
import com.example.demodataapi.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/score")
public class ScoreController {


    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping()
    public String Main() {
        return "Score Controller";
    }

    @GetMapping("product/{id}")
    public List<ProductShopperScore> getByShopper(@PathVariable(value = "id") String id, @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        return this.scoreService.FindAllByProduct(id, limit);
    }

    @GetMapping("shopper/{id}")
    public List<ProductShopperScore> getByProduct(
            @PathVariable(value = "id") String id,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(name = "category" ,required = false) Optional<String> category,
            @RequestParam(name = "brand" ,required = false) Optional<String> brand
            ) {
        return this.scoreService.FindAllByShopper(id, limit,brand,category);
    }

}
