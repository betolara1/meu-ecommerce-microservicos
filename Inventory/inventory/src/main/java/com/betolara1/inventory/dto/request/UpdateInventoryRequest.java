package com.betolara1.inventory.dto.request;

import com.betolara1.inventory.model.Inventory;

import lombok.Data;

@Data
public class UpdateInventoryRequest {
    private String sku;
    private Integer quantity;
    private Inventory.Status status;
}