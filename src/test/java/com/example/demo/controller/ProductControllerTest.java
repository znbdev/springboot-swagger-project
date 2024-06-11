package com.example.demo.controller;

import com.example.demo.service.ProductTblService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductTblService productTblService;

//    @Test
//    void testGetProductById() throws Exception {
//        Long productId = 1L;
//        ProductTbl product = new ProductTbl();
//        product.setId(productId);
//        product.setName("Test Product");
//
//        given(productTblService.findById(productId)).willReturn(Optional.of(product));
//
//        mockMvc.perform(get("/products/{id}", productId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(productId.intValue())))
//                .andExpect(jsonPath("$.name", is(product.getName())));
//    }

    @Test
    void testGetProductByIdReturns404IfNotFound() throws Exception {
        Long productId = 1L;

        given(productTblService.findById(productId)).willThrow(new RuntimeException("Product not found"));

        mockMvc.perform(get("/products/{id}", productId))
                .andExpect(status().isNotFound());
    }
}

