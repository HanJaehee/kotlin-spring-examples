package com.hindsight.board.domain.file

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("file")
data class File(
    val id: Long = 0,
    val postId: Long,
    val path: String,
    val name: String,
    val extension: String,
    val createdAt: LocalDateTime,
    val deletedAt: LocalDateTime?
)
