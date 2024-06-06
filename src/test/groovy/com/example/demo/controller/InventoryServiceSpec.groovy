package com.example.demo.controller

import com.example.demo.entity.Inventory
import spock.lang.Specification
import spock.lang.Subject
import com.example.demo.repository.InventoryRepository
import com.example.demo.service.InventoryService

// 1. Spock 框架的单元测试代码
class InventoryServiceSpec extends Specification {

    @Subject
    InventoryService inventoryService

    InventoryRepository inventoryRepositoryMock = Mock()

    def setup() {
        inventoryService = new InventoryService(inventoryRepositoryMock)
    }

    def "test purchaseInventory success"() {
        given: "a inventory ID and an inventory with sufficient quantity"
        Long inventoryId = 1L
        Inventory inventory = new Inventory(inventoryId: inventoryId, quantity: 1, version: 1)

        when: "the service is called to purchase the inventory"
        inventoryRepositoryMock.findByIdForUpdate(inventoryId) >> Optional.of(inventory)
        inventoryRepositoryMock.findById(inventoryId) >> Optional.of(inventory)
        inventoryService.purchaseInventory(inventoryId, 1)

        then: "the quantity is decreased and inventory is saved"
        1 * inventoryRepositoryMock.save(_) >> { Inventory savedInventory ->
            assert savedInventory.quantity == 0
        }
    }

    def "test purchaseInventory throws exception when insufficient inventory"() {
        given: "a inventory ID and an inventory with zero quantity"
        Long inventoryId = 1L
        Inventory inventory = new Inventory(inventoryId: inventoryId, quantity: 0)

        when: "the service is called to purchase the inventory"
        inventoryRepositoryMock.findByIdForUpdate(inventoryId) >> Optional.of(inventory)
        inventoryService.purchaseInventory(inventoryId)

        then: "a RuntimeException is thrown"
        thrown(RuntimeException)
        0 * inventoryRepositoryMock.save(_)
    }

    def "test cancelInventory success"() {
        given: "a inventory ID and an inventory"
        Long inventoryId = 1L
        Inventory inventory = new Inventory(inventoryId: inventoryId, quantity: 1)

        when: "the service is called to cancel the inventory"
        inventoryRepositoryMock.findByIdForUpdate(inventoryId) >> Optional.of(inventory)
        inventoryRepositoryMock.findById(inventoryId) >> Optional.of(inventory)
        inventoryService.cancelInventory(inventoryId, 1)

        then: "the quantity is increased and inventory is saved"
        1 * inventoryRepositoryMock.save(_) >> { Inventory savedInventory ->
            assert savedInventory.quantity == 2
        }
    }
}
