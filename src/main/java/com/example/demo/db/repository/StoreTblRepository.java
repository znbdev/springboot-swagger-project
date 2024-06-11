package com.example.demo.db.repository;

import com.example.demo.db.entity.StorePk;
import com.example.demo.db.entity.StoreTbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreTblRepository extends JpaRepository<StoreTbl, StorePk> {
    StoreTbl findByStorePk(StorePk key);
    void delete(StoreTbl entity);
    void deleteById(StorePk key);
}
