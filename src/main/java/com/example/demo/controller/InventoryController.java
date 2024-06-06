package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.ProductTbl;
import com.example.demo.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Inventory API")
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @ApiOperation(value = "Get All Products")
    @GetMapping("/getAll")
    public List<Inventory> getAll() {
        List<Inventory> inventoryList = inventoryService.findAll();
        log.info("Total Inventory: {}", inventoryList.size());
        return inventoryList;
    }

    @ApiOperation(value = "Create a Inventory")
    @PostMapping("/create")
    public Inventory create(Integer quantity) {
        Inventory inventory = new Inventory();
        inventory.setQuantity(quantity);
        return inventoryService.save(inventory);
    }

    @ApiOperation(value = "Update a Inventory")
    @PostMapping("/update")
    public ResponseEntity<?> updateInventory(Long id, Integer quantity) {
        return inventoryService.purchaseInventory(id, quantity);
    }
    
    @ApiOperation(value = "Update a Inventory")
    @PostMapping("/update2")
    public Object updateInventory2(Long id, Integer quantity) {
        return inventoryService.purchaseInventory2(id, quantity);
    }

    @ApiOperation(value = "Cancel a Inventory")
    @PostMapping("/cancel")
    public Object cancelInventory(Long id, Integer quantity) {
        return inventoryService.cancelInventory(id, quantity);
    }
    
}
