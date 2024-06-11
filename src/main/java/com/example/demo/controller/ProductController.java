package com.example.demo.controller;

import com.example.demo.db.entity.ProductTbl;
import com.example.demo.service.ProductTblService;
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
@Api(tags = "Product API")
@RequestMapping("/api/product")
public class ProductController {

    private final ProductTblService productTblService;

    @ApiOperation(value = "Get All Products")
    @GetMapping("/getAll")
    public List<ProductTbl> getAll() {
        List<ProductTbl> productList = productTblService.findAll();
        log.info("Total Products: {}", productList.size());
        return productList;
    }

    @ApiOperation(value = "Create a Product")
    @PostMapping("/create")
    public ProductTbl createProduct(String productName, String productDescription) {
        ProductTbl productTbl = new ProductTbl();
        productTbl.setName(productName);
        productTbl.setDescription(productDescription);
        return productTblService.save(productTbl);
    }

    @ApiOperation(value = "Update a Product")
    @PostMapping("/update")
    public ProductTbl updateProduct(Long id, String productName, String productDescription) {
        Optional<ProductTbl> productTbl = productTblService.findById(id);
        ProductTbl value = productTbl.orElseThrow(() -> new RuntimeException("Product not found"));
        log.info("Product found: {}", value);
        log.info("Create Date: {}", value.getCreateDate());
        log.info("Update Date: {}", value.getUpdateDate());
        value.setName(productName);
        value.setDescription(productDescription);
        return productTblService.save(value);
    }

    @ApiOperation(value = "Delete a Product")
    @PostMapping("/delete")
    public void deleteProduct(Long id) {
        productTblService.deleteById(id);
    }

}
