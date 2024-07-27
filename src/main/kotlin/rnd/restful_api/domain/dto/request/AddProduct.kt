package rnd.restful_api.domain.dto.request

import java.math.BigDecimal

data class AddProduct(
    val shopId: Long?, val productName: String?,
    val description: String?, val price: BigDecimal?)
{

}