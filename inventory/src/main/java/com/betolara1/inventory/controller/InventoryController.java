package com.betolara1.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betolara1.inventory.dto.InventoryDTO;
import com.betolara1.inventory.model.Inventory;
import com.betolara1.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> getAllInventory(){
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody Inventory inventory){
        Inventory newInventory = inventoryService.saveInventory(inventory);
        InventoryDTO inventoryDTO = new InventoryDTO(newInventory);

        return ResponseEntity.ok(inventoryDTO);
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

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory){
        Inventory inventoryDb = inventoryService.updateInventory(id, inventory);
        InventoryDTO inventoryDTO = new InventoryDTO(inventoryDb);

        return ResponseEntity.ok(inventoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id){
        inventoryService.deleteInventory(id);

        return ResponseEntity.noContent().build();
    }
}