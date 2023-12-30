package com.hindsight.board.util

object PasswordUtil {

    // 중요한 기능이 아니므로 Bcrypt, SHA-256 등으로 했다고 치자 ㅎㅎ;
    fun hashing(password: String): String = password.hashCode().toString()
}