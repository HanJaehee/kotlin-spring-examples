package com.hindsight.board.domain.category

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("category")
data class Category(
    val id: Long = 0,
    val name: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)