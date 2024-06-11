package com.example.demo.db.repository;

import com.example.demo.db.entity.CategoryTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryTblRepository extends JpaRepository<CategoryTbl, Long> {

    List<CategoryTbl> findByName(String name);

    List<CategoryTbl> findByNameAndDescription(String name, String description);
}