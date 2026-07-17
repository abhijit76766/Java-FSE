package com.cognizant.orderservice;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController { private final OrderRepository repository; private final UserClient userClient; public OrderController(OrderRepository repository, UserClient userClient){this.repository=repository;this.userClient=userClient;} @GetMapping public List<OrderEntity> all(){return repository.findAll();} @PostMapping public OrderEntity create(@RequestBody OrderEntity order){return repository.save(order);} @GetMapping("/{id}/summary") public Map<String,Object> summary(@PathVariable Long id){ OrderEntity order = repository.findById(id).orElseThrow(); return Map.of("order", order, "user", userClient.getUser(order.getUserId())); } }
