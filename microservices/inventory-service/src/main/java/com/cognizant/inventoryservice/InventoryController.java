package com.cognizant.inventoryservice;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController { private final InventoryRepository repository; private final ProductClient productClient; public InventoryController(InventoryRepository repository, ProductClient productClient){this.repository=repository;this.productClient=productClient;} @GetMapping("/products/{id}") public Map<String,Object> stock(@PathVariable Long id){ return Map.of("product", productClient.product(id), "inventory", repository.findAll()); } }
