package com.example.alpha.controller;

import com.example.alpha.client.BravoFeignClient;
import com.example.alpha.client.CharlieFeignClient;
import com.example.alpha.model.Alpha;
import com.example.alpha.model.dto.BravoResponse;
import com.example.alpha.model.dto.CharlieResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alpha")
public class AlphaController {

    private final BravoFeignClient bravoFeignClient;

    private final CharlieFeignClient charlieFeignClient;

    public AlphaController(BravoFeignClient bravoFeignClient, CharlieFeignClient charlieFeignClient) {
        this.bravoFeignClient = bravoFeignClient;
        this.charlieFeignClient = charlieFeignClient;
    }

    @GetMapping
    Alpha getAlpha() {
        return new Alpha("This is Alpha");
    }

    @GetMapping("/bravo")
    BravoResponse getBravoResponse() {
        return this.bravoFeignClient.getBravo();
    }

    @GetMapping("/charlie")
    CharlieResponse getCharlieResponse() {
        return this.charlieFeignClient.getCharlie();
    }
}
