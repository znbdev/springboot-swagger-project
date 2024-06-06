//package com.example.demo.controller
//
//import com.example.demo.entity.Inventory
//
//// 2. Spock 框架的集成测试代码
//// 接下来是集成测试代码，使用 @SpringBootTest 和 @MockBean 进行测试。
//import spock.lang.Specification
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import com.example.demo.service.InventoryService
//import com.example.demo.repository.InventoryRepository
//
//import static org.mockito.Mockito.*
//
//@SpringBootTest
//class InventoryServiceIntegrationSpec extends Specification {
//
//    @Autowired
//    InventoryService inventoryService
//
//    @MockBean
//    InventoryRepository inventoryRepository
//
//    def "test purchaseProduct success"() {
//        given: "a product ID and an inventory with sufficient quantity"
//        Long productId = 1L
//        Inventory inventory = new Inventory(productId: productId, quantity: 1)
//
//        when: "the service is called to purchase the product"
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory))
//        inventoryService.purchaseProduct(productId)
//
//        then: "the quantity is decreased and inventory is saved"
//        1 * inventoryRepository.save(_) >> { Inventory savedInventory ->
//            assert savedInventory.quantity == 0
//        }
//    }
//
//    def "test purchaseProduct throws exception when insufficient inventory"() {
//        given: "a product ID and an inventory with zero quantity"
//        Long productId = 1L
//        Inventory inventory = new Inventory(productId: productId, quantity: 0)
//
//        when: "the service is called to purchase the product"
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory))
//        inventoryService.purchaseProduct(productId)
//
//        then: "a RuntimeException is thrown"
//        thrown(RuntimeException)
//        0 * inventoryRepository.save(_)
//    }
//
//    def "test cancelProduct success"() {
//        given: "a product ID and an inventory"
//        Long productId = 1L
//        Inventory inventory = new Inventory(productId: productId, quantity: 1)
//
//        when: "the service is called to cancel the product"
//        when(inventoryRepository.findByIdForUpdate(productId)).thenReturn(Optional.of(inventory))
//        inventoryService.cancelProduct(productId)
//
//        then: "the quantity is increased and inventory is saved"
//        1 * inventoryRepository.save(_) >> { Inventory savedInventory ->
//            assert savedInventory.quantity == 2
//        }
//    }
//}
//
