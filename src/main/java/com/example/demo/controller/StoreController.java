package com.example.demo.controller;

import com.example.demo.bean.StoreBean;
import com.example.demo.entity.StoreTbl;
import com.example.demo.service.StoreTblService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Store API")
@RequestMapping("/api/store")
public class StoreController implements CrudController<StoreTbl> {

    private final StoreTblService storeTblService;
    @ApiOperation(value = "Get Store")
    @GetMapping("/getAllByName")
    public List<StoreTbl> getAllByName(StoreBean storeBean) {
        return storeTblService.findAllByName(storeBean.getName());
    }

    @Override
    @ApiOperation(value = "Get Store")
    @GetMapping("/get")
    public Optional<StoreTbl> get(Long id) {
        return storeTblService.findById(id);
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
    public StoreTbl create(StoreTbl entity) {
        return storeTblService.save(entity);
    }

    @Override
    @ApiOperation(value = "Update a Store")
    @PostMapping("/update")
    public StoreTbl update(Long id, StoreTbl entity) {
        return storeTblService.save(entity);
    }

    @Override
    public void delete(Long id) {
        storeTblService.deleteById(id);
    }
}
