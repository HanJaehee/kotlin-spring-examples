package com.hindsight.board.domain.user

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Long> {

    @Query("SELECT * FROM user WHERE user_id = :userId AND password = :password")
    suspend fun findUserIdAndPassword(userId: String, password: String): User?

    suspend fun existsByUserId(userId: String): Boolean
}