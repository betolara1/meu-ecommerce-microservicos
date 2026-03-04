package com.betolara1.inventory.dto.request;

import com.betolara1.inventory.model.Inventory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveInventoryRequest {
    @NotBlank(message = "SKU is required")
    private String sku;

    @NotNull(message = "Quantity is required")
    private Integer quantity;
    
    @NotNull(message = "Status is required")
    private Inventory.Status status;
}