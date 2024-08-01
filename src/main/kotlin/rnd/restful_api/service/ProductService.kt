package rnd.restful_api.service

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rnd.restful_api.constant.AppConstant.ResponseKey.Companion as ResponseKey
import rnd.restful_api.domain.dao.Product
import rnd.restful_api.domain.dto.request.AddProduct
import rnd.restful_api.domain.dto.response.BaseResponse
import rnd.restful_api.exception.GeneralException
import rnd.restful_api.repository.ProductRepository
import rnd.restful_api.util.ResponseUtil
import java.util.*

@Service
class ProductService (
    val productRepository: ProductRepository
) {
    private val log = KotlinLogging.logger {}

    fun getProducts(): ResponseEntity<BaseResponse<Any?>> {
        val listProduct: List<Product> = productRepository.findAll();

        if (listProduct.isEmpty()) {
            log.error { "Failed get list data products" }
            throw GeneralException(ResponseKey.GENERAL_ERROR, "failed list product data")
        }

        return ResponseUtil.buildResponse(ResponseKey.SUCCESS, "success get products data",
            listProduct, HttpStatus.OK)
    }

    fun addProduct(request: AddProduct): ResponseEntity<BaseResponse<Any?>> {
        val product: Product = Product(null, request.productName, request.description, request.price)

        productRepository.save(product)

        return ResponseUtil.buildResponse(ResponseKey.SUCCESS, "success add products data",
            null, HttpStatus.OK)
    }

    fun detailProduct(id: Long): ResponseEntity<BaseResponse<Any?>> {
       val product: Product = this.getProductById(id)

        return ResponseUtil.buildResponse(ResponseKey.SUCCESS, "success get product detail",
            product, HttpStatus.OK)
    }

    fun deleteProduct(id: Long): ResponseEntity<BaseResponse<Any?>> {
        val product: Product = this.getProductById(id)

        productRepository.delete(product)

        return ResponseUtil.buildResponse(ResponseKey.SUCCESS, "success get delete product",
            product, HttpStatus.OK)
    }

    private fun getProductById(id: Long): Product {
        val product: Optional<Product> = productRepository.findById(id)

        if (product.isEmpty) {
            log.error { "Failed get data products by id: $id" }
            throw GeneralException(ResponseKey.PRODUCT_NOT_FOUND, "failed get specific product data", HttpStatus.NOT_FOUND)
        }

        return product.get()
    }
}