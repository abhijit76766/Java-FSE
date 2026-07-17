package com.cognizant.inventoryservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service", url="${product.service.url:http://localhost:8088}")
public interface ProductClient { @GetMapping("/products/{id}") ProductDto product(@PathVariable Long id); record ProductDto(Long id, String name, int stock) {} }
