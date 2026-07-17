package com.cognizant.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner { private final OrderRepository repository; public DataLoader(OrderRepository repository){this.repository=repository;} public void run(String... args) { OrderEntity order = new OrderEntity(); order.setUserId(1L); order.setItem("Laptop"); order.setAmount(65000); repository.save(order); } }
