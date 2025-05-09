package com.example.alpha.client;

import com.example.alpha.model.dto.BravoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "bravo-feign-client", url = "${client.bravo.baseUrl}")
public interface BravoFeignClient {

    @GetMapping("/api/bravo")
    BravoResponse getBravo();
}
