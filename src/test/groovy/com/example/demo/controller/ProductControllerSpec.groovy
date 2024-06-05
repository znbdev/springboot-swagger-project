//package com.example.demo.controller
//
//import com.example.demo.entity.ProductTbl
//import spock.lang.Specification
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import com.example.demo.service.ProductTblService
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
//import static org.hamcrest.Matchers.is
//import static org.mockito.BDDMockito.given
//
//@WebMvcTest(ProductController)
//class ProductControllerSpec extends Specification {
//
//    @Autowired
//    private MockMvc mockMvc
//
//    @MockBean
//    private ProductTblService productTblService
//
//    def "test getProductById"() {
//        given: "a product ID"
//        Long productId = 1L
//
//        and: "a product returned by the service"
//        ProductTbl product = new ProductTbl(id: productId, name: "Test Product", description: "Test Description")
//        given(productTblService.getProductById(productId)).willReturn(product)
//
//        expect: "the controller returns the product"
//        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", productId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath('$.id', is(productId.intValue())))
//                .andExpect(jsonPath('$.name', is(product.name)))
//    }
//
//    def "test getProductById returns 404 if not found"() {
//        given: "a product ID"
//        Long productId = 1L
//
//        and: "no product is found by the service"
//        given(productTblService.getProductById(productId)).willThrow(new RuntimeException("Product not found"))
//
//        expect: "the controller returns a 404 status"
//        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", productId))
//                .andExpect(status().isNotFound())
//    }
//}
//
