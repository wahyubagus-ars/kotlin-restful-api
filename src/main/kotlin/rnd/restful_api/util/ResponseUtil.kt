package rnd.restful_api.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import rnd.restful_api.domain.dto.response.BaseResponse

class ResponseUtil {

    companion object {
        fun <T> buildResponse(responseKey: String, responseMessage: String, data: T?, statusCode: HttpStatus) : ResponseEntity<BaseResponse<T?>> {
            val baseResponse = BaseResponse(responseKey, responseMessage, data)

            return ResponseEntity(baseResponse, statusCode)
        }
    }

}