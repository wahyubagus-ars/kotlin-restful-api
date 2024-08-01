package rnd.restful_api

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertNotNull

@SpringBootTest
class CollectionTest {

    private val log = KotlinLogging.logger {}

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