package com.example.demo.service;

import com.example.demo.db.entity.ProductTbl;
import com.example.demo.db.repository.ProductTblRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ProductTblServiceTest {

    @InjectMocks
    private ProductTblService productTblService;

    @Mock
    private ProductTblRepository productTblRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        ProductTbl product = new ProductTbl();
        product.setId(productId);
        product.setName("Test Product");

        when(productTblRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<ProductTbl> result = productTblService.findById(productId);
        ProductTbl value = result.orElseThrow(() -> new RuntimeException("Product not found"));

        assertEquals(product, value);
    }

//    @Test
//    void testGetProductByIdThrowsExceptionIfNotFound() {
//        Long productId = 1L;
//
//        when(productTblRepository.findById(productId)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> productTblService.findById(productId));
//    }
}
