package com.hindsight.board.domain.post

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("post")
class Post private constructor(
    val id: Long = 0,
    val userId: String,
    val categoryId: Long,
    val name: String,
    val content: String,
    val viewCount: Int = 0,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime?,
    val deletedAt: LocalDateTime?
)
