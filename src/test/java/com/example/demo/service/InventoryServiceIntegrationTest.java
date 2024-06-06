//package com.example.demo.service;
//
//import com.example.demo.entity.Inventory;
//import com.example.demo.repository.InventoryRepository;
//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
////  使用 Spring Boot Test 和 Mockito 的集成测试代码
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest
//public class InventoryServiceIntegrationTest {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @MockBean
//    private InventoryRepository inventoryRepository;
//
//    @Test
//    public void testPurchaseProduct() {
//        Long productId = 1L;
//        Inventory inventory = new Inventory();
//        inventory.setProductId(productId);
//        inventory.setQuantity(1);
//
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));
//
//        inventoryService.purchaseProduct(productId);
//
//        verify(inventoryRepository, times(1)).save(inventory);
//        assert(inventory.getQuantity() == 0);
//    }
//
//    @Test
//    public void testPurchaseProductInsufficientInventory() {
//        Long productId = 1L;
//        Inventory inventory = new Inventory();
//        inventory.setProductId(productId);
//        inventory.setQuantity(0);
//
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));
//
//        assertThrows(RuntimeException.class, () -> inventoryService.purchaseProduct(productId));
//
//        verify(inventoryRepository, never()).save(inventory);
//    }
//
//    @Test
//    public void testCancelProduct() {
//        Long productId = 1L;
//        Inventory inventory = new Inventory();
//        inventory.setProductId(productId);
//        inventory.setQuantity(1);
//
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory));
//
//        inventoryService.cancelProduct(productId);
//
//        verify(inventoryRepository, times(1)).save(inventory);
//        assert(inventory.getQuantity() == 2);
//    }
//}
//
