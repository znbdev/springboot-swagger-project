package com.example.demo.service;

import com.example.demo.data.mongo.CombinedInventory;
import com.example.demo.data.mongo.CombinedInventoryRepository;
import com.example.demo.entity.InventoryTbl;
import com.example.demo.entity.ProductTbl;
import com.example.demo.entity.StoreTbl;
import com.example.demo.repository.InventoryTblRepository;
import com.example.demo.repository.ProductTblRepository;
import com.example.demo.repository.StoreTblRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SearchInventoryService {
    private final CombinedInventoryRepository mongoRepository;
    private final InventoryTblRepository oracleInventoryRepository;
    private final ProductTblRepository oracleProductRepository;
    private final StoreTblRepository oracleStoreRepository;

    @Transactional
    public CombinedInventory findByStoreIdAndProductId(Long storeId, Long productId) {
        // 从MongoDB检索数据
        Optional<CombinedInventory> mongoInventory = mongoRepository.findByStoreIdAndProductId(storeId, productId);
        if (mongoInventory.isPresent()) {
            return mongoInventory.get();
        }

        // 如果MongoDB没有数据，从Oracle获取
        InventoryTbl oracleInventory = oracleInventoryRepository.findByStoreIdAndProductId(storeId, productId);
        if (Objects.nonNull(oracleInventory)) {

            Optional<ProductTbl> oracleProduct = oracleProductRepository.findById(productId);
            Optional<StoreTbl> oracleStore = oracleStoreRepository.findById(storeId);

            if (oracleProduct.isPresent() && oracleStore.isPresent()) {
                CombinedInventory combinedInventory = new CombinedInventory();
                combinedInventory.setId(storeId + "_" + productId);
                combinedInventory.setStoreId(storeId);
                combinedInventory.setProductId(productId);
                combinedInventory.setQuantity(oracleInventory.getQuantity());

                StoreTbl store = oracleStore.get();
                combinedInventory.setStoreName(store.getName());
                combinedInventory.setStoreAddress(store.getAddress());
                combinedInventory.setStorePhoneNumber(store.getPhoneNumber());

                ProductTbl product = oracleProduct.get();
                combinedInventory.setProductName(product.getName());
                combinedInventory.setProductDescription(product.getDescription());

                // 更新MongoDB
                mongoRepository.save(combinedInventory);
                return combinedInventory;
            }
        }

        return null; // 或抛出异常
    }
}
