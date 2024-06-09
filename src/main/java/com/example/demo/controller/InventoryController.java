package com.example.demo.controller;

import com.example.demo.data.mongo.CombinedInventory;
import com.example.demo.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@Api(value = "InventoryController", tags = "Inventory Controller")
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/store/{storeId}/product/{productId}")
    @ApiOperation(value = "Find inventory by Store ID and Product ID", notes = "Find inventory by Store ID and Product ID, if not found in MongoDB then retrieve from Oracle and update MongoDB")
    public CombinedInventory getInventoryByStoreIdAndProductId(@PathVariable String storeId, @PathVariable Long productId) {
        return inventoryService.findByStoreIdAndProductId(storeId, productId);
    }
}