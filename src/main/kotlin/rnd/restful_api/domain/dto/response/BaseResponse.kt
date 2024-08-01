package rnd.restful_api.domain.dto.response;

data class BaseResponse<T>(
    val responseKey: String?,
    val responseMessage: String?,
    val data: T
)
