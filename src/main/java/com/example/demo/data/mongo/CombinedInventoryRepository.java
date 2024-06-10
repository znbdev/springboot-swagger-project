package com.example.demo.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CombinedInventoryRepository extends MongoRepository<CombinedInventory, Long> {
    Optional<CombinedInventory> findByStoreIdAndProductId(Long storeId, Long productId);
}