package com.cognizant.orderservice;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class OrderEntity { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private Long userId; private String item; private double amount; public Long getId(){return id;} public void setId(Long id){this.id=id;} public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;} public String getItem(){return item;} public void setItem(String item){this.item=item;} public double getAmount(){return amount;} public void setAmount(double amount){this.amount=amount;} }
