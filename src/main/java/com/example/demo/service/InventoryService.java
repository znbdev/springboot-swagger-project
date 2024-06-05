package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public void purchaseProduct(Long productId) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (inventory.getQuantity() > 0) {
            inventory.setQuantity(inventory.getQuantity() - 1);
            inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("Insufficient inventory");
        }
    }

    @Transactional
    public void cancelProduct(Long productId) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventory.setQuantity(inventory.getQuantity() + 1);
        inventoryRepository.save(inventory);
    }
}

