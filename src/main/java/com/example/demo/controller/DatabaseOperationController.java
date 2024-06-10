package com.example.demo.controller;

import com.example.demo.controller.common.DatabaseOperationManager;
import com.example.demo.dto.StoreRequestDTO;
import com.example.demo.entity.StoreTbl;
import com.example.demo.service.StoreTblService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Store API")
@RequestMapping("/api/store")
public class DatabaseOperationController implements DatabaseOperationManager<StoreRequestDTO, StoreTbl, Long> {

    private final StoreTblService storeTblService;


    @Override
    public StoreTbl get(Long key) {
        return null;
    }

    @Override
    public List<StoreTbl> getAll() {
        return List.of();
    }

    @Override
    public StoreTbl create(StoreRequestDTO dto) {
        return null;
    }

    @Override
    public StoreTbl update(StoreRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(Long key) {

    }
}
