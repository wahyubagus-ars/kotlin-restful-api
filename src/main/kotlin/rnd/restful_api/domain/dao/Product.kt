package rnd.restful_api.domain.dao

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String? = "",

    @Column(name = "description")
    val description: String? = "",

    @Column(name = "price")
    val price: BigDecimal? = BigDecimal.ZERO,
)