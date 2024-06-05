package com.example.demo.service;

import com.example.demo.entity.CategoryTbl;
import com.example.demo.repository.CategoryTblRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryTblService implements CrudService<CategoryTbl, Long> {
    private final CategoryTblRepository categoryTblRepository;

    public List<CategoryTbl> findProductByName(String name) {
        return categoryTblRepository.findByName(name);
    }

    @Override
    public List<CategoryTbl> findAll() {
        return categoryTblRepository.findAll();
    }

    @Override
    public Optional<CategoryTbl> findById(Long id) {
        return categoryTblRepository.findById(id);
    }

    @Override
    public CategoryTbl save(CategoryTbl entity) {
        return categoryTblRepository.save(entity);
    }

    @Override
    public CategoryTbl update(CategoryTbl entity) {
        return categoryTblRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        categoryTblRepository.deleteById(id);
    }
}
