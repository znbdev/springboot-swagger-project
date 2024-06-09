package com.example.demo.repository;

import com.example.demo.entity.InventoryTbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTblRepository extends JpaRepository<InventoryTbl, Long> {

    InventoryTbl findByStoreIdAndProductId(String storeId, Long productId);
}
