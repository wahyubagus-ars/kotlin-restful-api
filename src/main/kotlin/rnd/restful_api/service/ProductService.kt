package rnd.restful_api.service

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rnd.restful_api.domain.dao.Product
import rnd.restful_api.domain.dto.request.AddProduct
import rnd.restful_api.repository.ProductRepository
import java.util.*

@Service
class ProductService (
    val productRepository: ProductRepository
) {
    private val log = KotlinLogging.logger {}

    fun getProducts(): ResponseEntity<Any> {
        val listProduct: List<Product> = productRepository.findAll();

        if (listProduct.isEmpty()) {
            throw RuntimeException("GENERAL_ERROR");
        }

        return ResponseEntity(listProduct, HttpStatus.OK)
    }

    fun addProduct(request: AddProduct): ResponseEntity<Any> {
        val product: Product = Product(null, request.productName, request.description, request.price)
        productRepository.save(product)

        return ResponseEntity("success", HttpStatus.OK)
    }

    fun detailProduct(id: Long): ResponseEntity<Any> {
       val product: Product = this.getProductById(id)

        return ResponseEntity(product, HttpStatus.OK)
    }

    fun deleteProduct(id: Long): ResponseEntity<Any> {
        val product: Product = this.getProductById(id)

        productRepository.delete(product)

        return ResponseEntity(product, HttpStatus.OK)
    }

    private fun getProductById(id: Long): Product {
        val product: Optional<Product> = productRepository.findById(id)

        if (product.isEmpty) {
            throw RuntimeException("PRODUCT_NOT_FOUND")
        }

        return product.get()
    }
}