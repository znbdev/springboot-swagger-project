package com.example.demo.controller;

import com.example.demo.controller.common.CrudController;
import com.example.demo.data.dto.StoreDTO;
import com.example.demo.db.entity.StorePk;
import com.example.demo.db.entity.StoreTbl;
import com.example.demo.service.StoreTblService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Store API")
@RequestMapping("/api/store")
public class StoreController implements CrudController<StoreTbl, StorePk, StoreDTO> {

    private final StoreTblService storeTblService;

    public StoreTbl get(StorePk key) {
        return null;
    }

    @Override
    @ApiOperation(value = "Get All Store")
    @GetMapping("/getAll")
    public List<StoreTbl> getAll() {
        return storeTblService.findAll();
    }

    @Override
    @ApiOperation(value = "Create a Store")
    @PostMapping("/create")
    public StoreTbl create(StoreDTO dto) {
        StoreTbl storeTbl = new StoreTbl();
        storeTbl.setStorePk(new StorePk(dto.getStoreId(), dto.getLocationId()));
        storeTbl.setName(dto.getName());
        storeTbl.setAddress(dto.getAddress());
        storeTbl.setPhoneNumber(dto.getPhoneNumber());
        return storeTblService.save(storeTbl);
    }

    @Override
    public StoreTbl update(StoreDTO dto) {
        return null;
    }

    @Override
    public void delete(StoreTbl entity) {
        storeTblService.delete(entity);
    }
}
