package com.example.alpha.client;

import com.example.alpha.model.dto.CharlieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "charlie-feign-client", url = "${client.charlie.baseUrl}")
public interface CharlieFeignClient {

    @GetMapping("/api/charlie")
    CharlieResponse getCharlie();
}
