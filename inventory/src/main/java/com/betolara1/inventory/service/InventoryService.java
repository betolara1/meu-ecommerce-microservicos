package com.betolara1.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betolara1.inventory.dto.InventoryDTO;
import com.betolara1.inventory.model.Inventory;
import com.betolara1.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryDTO> getAllInventory(){
        return inventoryRepository.findAll()
            .stream().map(InventoryDTO::new).collect(Collectors.toList());
    }

    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public InventoryDTO getInventoryById(Long id){
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        return new InventoryDTO(inventory);
    }

    public InventoryDTO getInventoryBySku(String sku){
        Inventory inventory = inventoryRepository.findBySku(sku);
        
        if(inventory == null){
            throw new RuntimeException("Inventory not found");
        }
        return new InventoryDTO(inventory);
    }

    public Inventory updateInventory(Long id, Inventory updateInventory){
        Inventory findInventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        
        findInventory.setSku(updateInventory.getSku());
        findInventory.setQuantity(updateInventory.getQuantity());
        findInventory.setReserved(updateInventory.getReserved());

        return inventoryRepository.save(findInventory);
    }

    public void deleteInventory(Long id){
        Inventory findInventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        inventoryRepository.delete(findInventory);
    }
}
