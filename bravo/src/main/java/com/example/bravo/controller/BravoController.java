package com.example.bravo.controller;

import com.example.bravo.model.Bravo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bravo")
public class BravoController {

    @GetMapping
    Bravo getBravo(HttpServletRequest request) {
        String scheme = request.isSecure() ? "https" : "http";
        String message = String.format("This is Bravo, ACK [%s] request", scheme);
        return new Bravo(message);
    }
}
