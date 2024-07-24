package rnd.restful_api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rnd.restful_api.service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService) {

    @GetMapping("/")
    fun getProducts(): ResponseEntity<Any> {
        return productService.getProducts();
    }

}