package com.cognizant.productservice;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController { private final ProductRepository repository; public ProductController(ProductRepository repository){this.repository=repository;} @GetMapping public List<Product> all(){return repository.findAll();} @GetMapping("/{id}") public Product one(@PathVariable Long id){return repository.findById(id).orElseThrow();} @PostMapping public Product create(@RequestBody Product product){return repository.save(product);} }
