package rnd.restful_api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import rnd.restful_api.constant.AppConstant
import rnd.restful_api.domain.dto.response.BaseResponse
import rnd.restful_api.util.ResponseUtil

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(GeneralException::class)
    fun handleGeneralException(ex: GeneralException): ResponseEntity<BaseResponse<Any?>> {
        val responseKey = ex.responseKey
        val responseMessage = ex.message
        val statusCode = ex.statusCode

        return ResponseUtil.buildResponse(responseKey, responseMessage, null, statusCode)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<BaseResponse<Any?>> {
        val responseKey = AppConstant.ResponseKey.GENERAL_ERROR
        val responseMessage = ex.message ?: "An unexpected error occurred"

        return ResponseUtil.buildResponse(responseKey, responseMessage, null, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}