package com.cognizant.inventoryservice;

import jakarta.persistence.*;

@Entity
public class InventoryRecord { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private Long productId; private int available; public Long getId(){return id;} public void setId(Long id){this.id=id;} public Long getProductId(){return productId;} public void setProductId(Long productId){this.productId=productId;} public int getAvailable(){return available;} public void setAvailable(int available){this.available=available;} }
