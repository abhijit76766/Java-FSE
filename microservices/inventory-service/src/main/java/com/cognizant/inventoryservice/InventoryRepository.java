package com.cognizant.inventoryservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryRecord, Long> {}
