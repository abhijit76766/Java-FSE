package com.cognizant.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner { private final ProductRepository repository; public DataLoader(ProductRepository repository){this.repository=repository;} public void run(String... args) { Product p = new Product(); p.setName("Keyboard"); p.setStock(25); repository.save(p); } }
