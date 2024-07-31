package rnd.restful_api.domain.dao

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = "",

    @Column(name = "description")
    var description: String? = "",

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,
)