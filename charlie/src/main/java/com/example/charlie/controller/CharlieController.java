package com.example.charlie.controller;

import com.example.charlie.model.Charlie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/charlie")
public class CharlieController {

    @GetMapping
    Charlie getCharlie() {
        return new Charlie("This is Charlie");
    }
}
