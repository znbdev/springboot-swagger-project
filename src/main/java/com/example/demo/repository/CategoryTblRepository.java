package com.example.demo.repository;

import com.example.demo.entity.CategoryTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryTblRepository extends JpaRepository<CategoryTbl, Long> {

    List<CategoryTbl> findByName(String name);

    List<CategoryTbl> findByNameAndDescription(String name, String description);
}