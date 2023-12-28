package com.hindsight.board.domain.comment

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("comment")
data class Comment(
    val id: Long = 0,
    val userId: String,
    val postId: Long,
    val subCommentId: Long?,
    val content: String,
    val createdAt: LocalDateTime,
    val deletedAt: LocalDateTime?
)
