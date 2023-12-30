package com.hindsight.board.exception

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler(RuntimeException::class)
    suspend fun runtimeExceptionHandler(e: RuntimeException): ErrorResponse =
        ErrorResponse(message = e.message ?: "예상치 못한 에러 발생")

    @ExceptionHandler(GlobalException::class)
    suspend fun globalExceptionHandler(e: GlobalException): ErrorResponse =
        ErrorResponse(message = e.globalMessage.message)

}
