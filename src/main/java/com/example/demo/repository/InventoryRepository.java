package com.example.demo.repository;

import com.example.demo.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Repository-Level Implementation of Pessimistic Locking
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT i FROM Inventory i WHERE i.productId = :productId")
    Optional<Inventory> findByIdForUpdate(@Param("productId") Long productId);
}