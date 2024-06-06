//package com.example.demo.controller
//
//import com.example.demo.entity.Inventory
//import spock.lang.Specification
//import spock.lang.Subject
//import com.example.demo.repository.InventoryRepository
//import com.example.demo.service.InventoryService
//
//// 1. Spock 框架的单元测试代码
//class InventoryServiceSpec extends Specification {
//
//    @Subject
//    InventoryService inventoryService
//
//    InventoryRepository inventoryRepository = Mock()
//
//    def setup() {
//        inventoryService = new InventoryService(inventoryRepository)
//    }
//
//    def "test purchaseProduct success"() {
//        given: "a product ID and an inventory with sufficient quantity"
//        Long productId = 1L
//        Inventory inventory = new Inventory(productId: productId, quantity: 1)
//
//        when: "the service is called to purchase the product"
//        inventoryRepository.findByIdForUpdate(productId) >> Optional.of(inventory)
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
//        inventoryRepository.findByIdForUpdate(productId) >> Optional.of(inventory)
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
//        inventoryRepository.findByIdForUpdate(productId) >> Optional.of(inventory)
//        inventoryService.cancelProduct(productId)
//
//        then: "the quantity is increased and inventory is saved"
//        1 * inventoryRepository.save(_) >> { Inventory savedInventory ->
//            assert savedInventory.quantity == 2
//        }
//    }
//}
