package com.example.demo.service;

import com.example.demo.db.entity.ProductTbl;
import com.example.demo.db.repository.ProductTblRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductTblService implements CrudService<ProductTbl, Long> {
    private final ProductTblRepository productTblRepository;

    public List<ProductTbl> findProductByName(String name) {
        return productTblRepository.findByName(name);
    }

    public void saveIfNotExist(ProductTbl entity) {
        List<ProductTbl> existingProducts = productTblRepository.findByNameAndDescription(entity.getName(), entity.getDescription());
        if (existingProducts.isEmpty()) {
            productTblRepository.save(entity);
        }
    }

    @Override
    public List<ProductTbl> findAll() {
        return productTblRepository.findAll();
    }

    @Override
    public Optional<ProductTbl> findById(Long id) {
        return productTblRepository.findById(id);
    }

    @Override
    public ProductTbl save(ProductTbl entity) {
        return productTblRepository.save(entity);
    }

    @Override
    public ProductTbl update(ProductTbl entity) {
        return productTblRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        productTblRepository.deleteById(id);
    }
}
