package rnd.restful_api.service

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestPropertySource
import rnd.restful_api.domain.dao.Product
import rnd.restful_api.repository.ProductRepository
import java.math.BigDecimal
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
    fun testCollection() {
        val collectionList = listOf<String>("item1", "item2", "item3");

        val newCollection = collectionList.map { it.uppercase() }

        log.info { "new collection values: $newCollection "}

        assertNotNull(newCollection)
    }

    @Test
    fun testFilterCollection() {
        val collectionList = listOf<Int>(1,2,3,4,5)
            .filter { it > 3 }
            .toList()

        log.info { collectionList }
    }

    @Test
    fun testCollectionListToMap() {
        val collectionList = listOf<String>("item11", "item222", "item3")

        val pairCollection = collectionList.associate { Pair(it, it.length) }

        log.info { "pair collection: " to pairCollection }

        val pairCollectionWith = collectionList.associateWith { it.length }

        log.info { "associate collection with: " to pairCollectionWith }

        val pairCollectionBy = collectionList.associateBy { it.length }

        log.info { "associate collection by: $pairCollectionBy "}
    }
    @Test
    fun testMapCollection() {
        val map = mapOf<String, String>("key1" to "value1", "key2" to "value2")

        map.forEach{ (key, value) ->
            log.info { "key: $key and value: $value "}
        }

        val list = map.toList();

        log.info { list }
    }
}