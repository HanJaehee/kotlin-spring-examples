package com.hindsight.board.exception

import org.springframework.http.HttpStatus

enum class ExceptionLevel {
    WARNING,
    CRITICAL
}

enum class GlobalMessage(val message: String, val code: HttpStatus, val level: ExceptionLevel) {
    DUPLICATE_USER_ID(message = "아이디가 중복되었습니다.", code = HttpStatus.CONFLICT, level = ExceptionLevel.WARNING),
    FAIL_LOGIN(message = "로그인 실패", code = HttpStatus.BAD_REQUEST, level = ExceptionLevel.WARNING)
    ;
}