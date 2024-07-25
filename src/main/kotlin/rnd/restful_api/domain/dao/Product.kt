package rnd.restful_api.domain.dao

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "product")
class Product {

    @Id
    @GeneratedValue
    var id: Long? = null;
    var name: String = "";
    var description: String = "";
    var price: BigDecimal = BigDecimal.ZERO;
}