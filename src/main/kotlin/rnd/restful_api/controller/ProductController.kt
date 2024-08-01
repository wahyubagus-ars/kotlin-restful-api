package rnd.restful_api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rnd.restful_api.domain.dto.request.AddProduct
import rnd.restful_api.domain.dto.request.DetailProduct
import rnd.restful_api.domain.dto.response.BaseResponse
import rnd.restful_api.service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService) {

    @GetMapping("/")
    fun getProducts(): ResponseEntity<BaseResponse<Any?>> {
        return productService.getProducts();
    }

    @PostMapping("/")
    fun addProduct(@RequestBody request: AddProduct): ResponseEntity<BaseResponse<Any?>> {
        return productService.addProduct(request)
    }

    @PutMapping("/{id}")
    fun detailProduct(@PathVariable(name = "id") id: Long): ResponseEntity<BaseResponse<Any?>> {
        return productService.detailProduct(id)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable(name = "id") id: Long): ResponseEntity<BaseResponse<Any?>> {
        return productService.deleteProduct(id)
    }
}