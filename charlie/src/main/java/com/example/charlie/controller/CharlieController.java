package com.example.charlie.controller;

import com.example.charlie.model.Charlie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/charlie")
public class CharlieController {

    @GetMapping
    Charlie getCharlie(HttpServletRequest request) {
        String scheme = request.isSecure() ? "https" : "http";
        String message = String.format("This is Charlie, ACK [%s] request", scheme);
        return new Charlie(message);
    }
}
