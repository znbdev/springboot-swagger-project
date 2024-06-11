package com.example.demo.service


import spock.lang.Specification
import com.example.demo.db.repository.ProductTblRepository

class ProductTblServiceSpec extends Specification {

    ProductTblService productTblService
    ProductTblRepository productTblRepository = Mock()

    def setup() {
        productTblService = new ProductTblService(productTblRepository)
    }

//    def "test getProductById"() {
//        given: "a product ID"
//        Long productId = 1L
//
//        and: "a product returned by repository"
//        ProductTbl product = new ProductTbl(id: productId, name: "Test Product")
//        productTblRepository.findById(productId) >> Optional.of(product)
//
//        when: "the service is called to get the product by ID"
//        ProductTbl result = productTblService.findById(productId)
//
//        then: "the returned product is as expected"
//        result == product
//    }

    def "test getProductById throws exception if not found"() {
        given: "a product ID"
        Long productId = 1L

        and: "no product is found in the repository"
        productTblRepository.findById(productId) >> Optional.empty()

        when: "the service is called to get the product by ID"
        productTblService.getProductById(productId)

        then: "an exception is thrown"
        thrown(RuntimeException)
    }
}

