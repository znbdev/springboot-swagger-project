package com.example.demo.service;

import com.example.demo.entity.InventoryId;
import com.example.demo.entity.InventoryTbl;
import com.example.demo.repository.InventoryTblRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class InventoryTblService implements CrudService<InventoryTbl, InventoryId> {
    private final InventoryTblRepository inventoryTblRepository;

    public void saveIfNotExist(InventoryTbl entity) {

    }

    @Override
    public List<InventoryTbl> findAll() {
        return inventoryTblRepository.findAll();
    }

    @Override
    public Optional<InventoryTbl> findById(InventoryId inventoryId) {
        return Optional.empty();
    }

    @Override
    public InventoryTbl save(InventoryTbl entity) {
        return inventoryTblRepository.save(entity);
    }

    @Override
    public InventoryTbl update(InventoryTbl entity) {
        return inventoryTblRepository.save(entity);
    }

    @Override
    public void deleteById(InventoryId inventoryId) {

    }
}
