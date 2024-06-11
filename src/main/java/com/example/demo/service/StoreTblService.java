package com.example.demo.service;

import com.example.demo.data.dto.StoreDTO;
import com.example.demo.db.entity.StorePk;
import com.example.demo.db.entity.StoreTbl;
import com.example.demo.db.repository.StoreTblRepository;
import com.example.demo.service.common.RecordOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreTblService implements RecordOperations<StoreTbl, StorePk> {

    private final StoreTblRepository storeTblRepository;

    @Transactional
    public StoreDTO saveDto(StoreDTO storeDTO) {
        com.example.demo.db.entity.StoreTbl entity = new com.example.demo.db.entity.StoreTbl();
        StorePk storePk = new StorePk(storeDTO.getStoreId(), storeDTO.getLocationId());
        entity.setStorePk(storePk);
        entity.setName(storeDTO.getName());
        entity.setAddress(storeDTO.getAddress());
        entity.setPhoneNumber(storeDTO.getPhoneNumber());

        com.example.demo.db.entity.StoreTbl savedEntity = storeTblRepository.save(entity);
        storeDTO.setStoreId(savedEntity.getStorePk().getStoreId());
        storeDTO.setLocationId(savedEntity.getStorePk().getLocationId());

        return storeDTO;
    }

    public void saveIfNotExist(com.example.demo.db.entity.StoreTbl entity) {
        if (ObjectUtils.isEmpty(storeTblRepository.findByStorePk(entity.getStorePk()))) {
            storeTblRepository.save(entity);
        }
    }

    @Override
    public List<StoreTbl> findAll() {
        return storeTblRepository.findAll();
    }

    @Override
    public Optional<StoreTbl> findByPk(StorePk key) {
        return Optional.empty();
    }

    @Override
    public StoreTbl save(StoreTbl entity) {
        return storeTblRepository.save(entity);
    }

    @Override
    public void delete(StoreTbl entity) {
        storeTblRepository.delete(entity);
    }

}
