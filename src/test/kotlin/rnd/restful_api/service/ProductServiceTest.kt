package rnd.restful_api.service

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestPropertySource
import rnd.restful_api.domain.dao.Product
import rnd.restful_api.domain.dto.request.AddProduct
import rnd.restful_api.exception.GeneralException
import rnd.restful_api.repository.ProductRepository
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
@TestPropertySource(locations = ["classpath:application-test.properties"])
class ProductServiceTest {

    private val log = KotlinLogging.logger {}

    @MockBean
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var productService: ProductService

    @Test
    fun getProductsTestSuccess() {
        `when`(productRepository.findAll())
            .thenReturn(listOf(Product(1L, "Product Name", "", BigDecimal(9000))))
        val response = productService.getProducts()

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun getProductsTestError() {
        `when`(productRepository.findAll())
            .thenReturn(listOf())

        val exception = assertThrows<GeneralException> {
            productService.getProducts()
        }

        assertNotNull(exception)
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.statusCode)
    }

    @Test
    fun addProductTestSuccess() {
        val request = AddProduct(null, "Product Test", "Description test", BigDecimal.ZERO)
        val response = productService.addProduct(request)

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun detailProductTestSuccess() {
        `when`(productRepository.findById(any()))
            .thenReturn(Optional.of(Product()))

        val response = productService.detailProduct(1L)

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun detailProductTestNotFound() {
        `when`(productRepository.findById(any()))
            .thenReturn(Optional.empty())

        val exception = assertThrows<GeneralException> {
            productService.detailProduct(1L)
        }

        assertNotNull(exception)
        assertEquals(HttpStatus.NOT_FOUND, exception.statusCode)
    }

    @Test
    fun deleteProductTestSuccess() {
        `when`(productRepository.findById(any()))
            .thenReturn(Optional.of(Product()))

        val response = productService.deleteProduct(1L)

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
    }
}