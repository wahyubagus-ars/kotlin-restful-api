package rnd.restful_api.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun getProducts(): ResponseEntity<Any> {
        return ResponseEntity("value", HttpStatus.OK)
    }

}