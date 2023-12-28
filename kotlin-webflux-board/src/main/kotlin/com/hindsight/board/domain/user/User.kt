package com.hindsight.board.domain.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user")
data class User(
    @Id
    val id: Long = 0,
    val userId: String,
    val password: String,
    val nickname: String?,
    val isAdmin: Boolean,
    val status: Status,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
) {
    enum class Status {
        RUNNING,
        STOP
    }

    companion object {
        operator fun invoke(createDto: UserDto.Create) = User(
            userId = createDto.userId,
            password = createDto.password,
            nickname = createDto.nickname,
            isAdmin = createDto.isAdmin,
            createdAt = LocalDateTime.now(),
            status = Status.RUNNING,
            updatedAt = null
        )
    }
}


abstract class UserDto {

    data class Create(
        val userId: String,
        val password: String,
        val nickname: String,
        val isAdmin: Boolean
    )
}
