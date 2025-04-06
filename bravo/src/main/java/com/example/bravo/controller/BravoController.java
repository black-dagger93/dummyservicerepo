package com.example.bravo.controller;

import com.example.bravo.model.Bravo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bravo")
public class BravoController {

    @GetMapping
    Bravo getBravo() {
        return new Bravo("This is Bravo");
    }
}
