package rnd.restful_api.exception;

import org.springframework.http.HttpStatus

class GeneralException(val responseKey: String, override val message: String, val statusCode: HttpStatus)
    : RuntimeException(message) {

    constructor(responseKey: String, message: String): this(
        responseKey = responseKey,
        message = message,
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR
    )
}
