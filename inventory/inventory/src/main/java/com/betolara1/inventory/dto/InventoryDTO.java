package com.betolara1.inventory.dto;

import com.betolara1.inventory.model.Inventory;

import lombok.Data;

@Data
public class InventoryDTO {

    private Long id;
    private String sku;
    private int quantity;
    private int reserved;

    public InventoryDTO() {
    }

    public InventoryDTO(Inventory inventory) {
        this.id = inventory.getId();
        this.sku = inventory.getSku();
        this.quantity = inventory.getQuantity();
        this.reserved = inventory.getReserved();
    }
}
