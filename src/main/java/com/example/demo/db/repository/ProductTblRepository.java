package com.example.demo.db.repository;

import com.example.demo.db.entity.ProductTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTblRepository extends JpaRepository<ProductTbl, Long> {

    List<ProductTbl> findByName(String name);

    List<ProductTbl> findByNameAndDescription(String name, String description);
}