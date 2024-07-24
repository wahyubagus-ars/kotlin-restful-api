package rnd.restful_api.domain.dao

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Product(

    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,
    var description: String,
    var price: BigDecimal
) {
    constructor() : this(null, "", "", BigDecimal.ZERO) {

    }
}