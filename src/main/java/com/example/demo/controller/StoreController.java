package com.example.demo.controller;

import com.example.demo.bean.StoreBean;
import com.example.demo.dto.StoreRequestDTO;
import com.example.demo.entity.StoreTbl;
import com.example.demo.service.StoreTblService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Validated
@RequiredArgsConstructor
@Slf4j
@RestController
@Api(tags = "Store API")
@RequestMapping("/api/store")
public class StoreController implements CrudController<StoreTbl> {

    private final StoreTblService storeTblService;

    @ApiOperation(value = "Get Store")
    @GetMapping("/get3")
    public Optional<StoreTbl> get3(@Valid StoreRequestDTO storeRequestDTO) {
        Long id = storeRequestDTO.getId();
        return storeTblService.findById(id);
    }

    @ApiOperation(value = "Get Store")
    @GetMapping("/getAllByName")
    public List<StoreTbl> getAllByName(StoreBean storeBean) {
        return storeTblService.findAllByName(storeBean.getName());
    }

    @Override
    @ApiOperation(value = "Get Store")
    @GetMapping("/get")
    public Optional<StoreTbl> get(@ApiParam(value = "Store ID", required = true)
                                  @RequestParam(required = false) Long id) {
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
    public StoreTbl update(Long id, StoreTbl entity) {
        return null;
    }

//    @Override
//    @ApiOperation(value = "Update a Store")
//    @PutMapping("/update/{id}")
//    public StoreTbl update(@PathVariable Long id, @RequestBody StoreRequestDTO dto) {
//        Optional<StoreTbl> entity = storeTblService.findById(id);
//        if (entity.isEmpty()) {
//            throw new IllegalArgumentException("Store not found for id: " + id);
//        }
//        entity.get().setName(dto.getName());
//        entity.get().setAddress(dto.getAddress());
//        entity.get().setPhoneNumber(dto.getPhoneNumber());
//        return storeTblService.save(entity.get());
//    }


//    @PutMapping("/{id}")
//    public StoreTbl updateUser(@PathVariable Long id, @RequestBody StoreTbl storeTbl) {
//        storeTbl.setId(id);
//        return storeTblService.save(storeTbl);
//    }

    @Override
    public void delete(Long id) {
        storeTblService.deleteById(id);
    }

//    @Override
//    public StoreTbl put(Long id, StoreRequestDTO o) {
//        return null;
//    }
}
