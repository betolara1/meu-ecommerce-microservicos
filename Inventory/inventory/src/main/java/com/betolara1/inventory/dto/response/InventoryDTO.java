package com.betolara1.inventory.dto.response;

import java.time.LocalDateTime;

import com.betolara1.inventory.model.Inventory;

import lombok.Data;

@Data
public class InventoryDTO {

    private Long id;
    private String sku;
    private Integer quantity;
    private Inventory.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InventoryDTO() {}

    public InventoryDTO(Inventory inventory) {
        this.id = inventory.getId();
        this.sku = inventory.getSku();
        this.quantity = inventory.getQuantity();
        this.status = inventory.getStatus();
        this.createdAt = inventory.getCreatedAt();
        this.updatedAt = inventory.getUpdatedAt();
    }
}
