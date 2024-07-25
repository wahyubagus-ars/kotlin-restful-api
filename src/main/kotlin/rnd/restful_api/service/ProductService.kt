package rnd.restful_api.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rnd.restful_api.domain.dao.Product
import rnd.restful_api.repository.ProductRepository
import java.lang.RuntimeException

@Service
class ProductService(val productRepository: ProductRepository) {

    fun getProducts(): ResponseEntity<Any> {

        val listProduct: List<Product> = productRepository.findAll();

        if (listProduct.isEmpty()) {
            throw RuntimeException("GENERAL_ERROR");
        }

        return ResponseEntity(listProduct, HttpStatus.OK)
    }

}