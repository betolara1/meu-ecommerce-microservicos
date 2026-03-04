package com.betolara1.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveInventoryRequest {
    @NotBlank(message = "SKU is required")
    private String sku;

    @NotNull(message = "Quantity is required")
    private Integer quantity;
}