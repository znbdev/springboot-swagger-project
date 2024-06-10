package com.example.demo.service;

import com.example.demo.entity.StoreTbl;
import com.example.demo.repository.StoreTblRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreTblService implements CrudService<StoreTbl, Long> {

    private final StoreTblRepository storeTblRepository;

    public void saveIfNotExist(StoreTbl entity) {
        if (storeTblRepository.findById(entity.getId()).isEmpty()) {
            storeTblRepository.save(entity);
        }
    }

    public List<StoreTbl> findAllByName(String storeName) {
        return storeTblRepository.findAllByName(storeName);
    }

    @Override
    public List<StoreTbl> findAll() {
        return storeTblRepository.findAll();
    }

    @Override
    public Optional<StoreTbl> findById(Long aLong) {
        return Optional.empty();
    }


    @Override
    public StoreTbl save(StoreTbl entity) {
        return storeTblRepository.save(entity);
    }

    @Override
    public StoreTbl update(StoreTbl entity) {
        return storeTblRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {

    }


}
