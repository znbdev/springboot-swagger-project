package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// 使用 Mockito 和 JUnit 的单元测试代码
class InventoryServiceTest {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPurchaseProduct() {
        Long productId = 1L;
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(1);

        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));

        inventoryService.purchaseProduct(productId);

        verify(inventoryRepository, times(1)).save(inventory);
        assert(inventory.getQuantity() == 0);
    }

    @Test
    void testPurchaseProductInsufficientInventory() {
        Long productId = 1L;
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(0);

        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));

        assertThrows(RuntimeException.class, () -> inventoryService.purchaseProduct(productId));

        verify(inventoryRepository, never()).save(inventory);
    }

    @Test
    void testCancelProduct() {
        Long productId = 1L;
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(1);

        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));

        inventoryService.cancelProduct(productId);

        verify(inventoryRepository, times(1)).save(inventory);
        assert(inventory.getQuantity() == 2);
    }
}
