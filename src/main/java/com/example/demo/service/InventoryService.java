package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class InventoryService implements CrudService<Inventory, Long> {

    private final String errorMsg1 = "Insufficient stock to purchase the required quantity.";

    private final InventoryRepository inventoryRepository;

    @Transactional
    public ResponseEntity<?> purchaseInventory(Long inventoryId, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        if (inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            Inventory result = inventoryRepository.save(inventory);
            log.info("Result: {}", result);
            return ResponseEntity.ok(result);
        } else {
            ErrorResponse errorResponse = createErrorResponse(HttpStatus.BAD_REQUEST.value(),errorMsg1);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse); // Or create a custom error object with the message.
        }
    }

    @Transactional
    public HttpEntity<?> purchaseInventory2(Long inventoryId, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        if (inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            Inventory result = inventoryRepository.save(inventory);
            log.info("Result: {}", result);
            return ResponseEntity.ok(result);
        } else {
            ErrorResponse errorResponse = createErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMsg1 + "2");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    private static ErrorResponse createErrorResponse(int status, String errorMsg) {
        // Create a custom error object with the message.
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status);
        errorResponse.setMessage(errorMsg);
        log.error(errorMsg);
        return errorResponse;
    }

    @Transactional
    public Inventory cancelInventory(Long inventoryId, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setQuantity(inventory.getQuantity() + quantity);

        try {
            inventory = inventoryRepository.save(inventory);
            log.info("----------{}", inventory);
        } catch (OptimisticLockException e) {
            inventory = inventoryRepository.save(inventory);
            log.warn("=========={}", inventory);
        }

        return inventory;
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Inventory save(Inventory entity) {
        return inventoryRepository.save(entity);
    }

    @Override
    public Inventory update(Inventory entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}

