package com.betolara1.inventory.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betolara1.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySku(String sku);
    Page<Inventory> findAll(Pageable pageable);
    Page<Inventory> findByStatus(Inventory.Status status, Pageable pageable);
}
