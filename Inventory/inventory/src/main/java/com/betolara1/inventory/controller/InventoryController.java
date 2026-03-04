package com.betolara1.inventory.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betolara1.inventory.dto.request.SaveInventoryRequest;
import com.betolara1.inventory.dto.request.UpdateInventoryRequest;
import com.betolara1.inventory.dto.response.InventoryDTO;
import com.betolara1.inventory.model.Inventory;
import com.betolara1.inventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<InventoryDTO>> getAllInventory(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size){
            
        return ResponseEntity.ok(inventoryService.getAllInventory(page, size));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<InventoryDTO>> getInventoryByStatus(
        @PathVariable Inventory.Status status,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size){
            
        return ResponseEntity.ok(inventoryService.getInventoryByStatus(status, page, size));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Long id){
        InventoryDTO inventoryId = inventoryService.getInventoryById(id);
        return ResponseEntity.ok(inventoryId);
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<InventoryDTO> getInventoryBySku(@PathVariable String sku){
        InventoryDTO inventorySku = inventoryService.getInventoryBySku(sku);
        return ResponseEntity.ok(inventorySku);
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@Valid @RequestBody SaveInventoryRequest inventory){
        Inventory newInventory = inventoryService.saveInventory(inventory);
        InventoryDTO inventoryDTO = new InventoryDTO(newInventory);

        return ResponseEntity.ok(inventoryDTO);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @Valid @RequestBody UpdateInventoryRequest inventory){
        Inventory inventoryDb = inventoryService.updateInventory(id, inventory);
        InventoryDTO inventoryDTO = new InventoryDTO(inventoryDb);

        return ResponseEntity.ok(inventoryDTO);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id){
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok("Estoque deletado com sucesso!");
    }
}