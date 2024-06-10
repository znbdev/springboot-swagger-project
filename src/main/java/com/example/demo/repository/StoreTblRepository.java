package com.example.demo.repository;

import com.example.demo.entity.StoreTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreTblRepository extends JpaRepository<StoreTbl, Long> {
    List<StoreTbl> findAllByName(String name);
}
