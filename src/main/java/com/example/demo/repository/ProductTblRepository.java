package com.example.demo.repository;

import com.example.demo.entity.ProductTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTblRepository extends JpaRepository<ProductTbl, Long> {

    List<ProductTbl> findByName(String name);

    List<ProductTbl> findByNameAndDescription(String name, String description);
}