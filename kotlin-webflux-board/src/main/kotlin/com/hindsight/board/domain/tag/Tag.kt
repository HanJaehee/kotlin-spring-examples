package com.hindsight.board.domain.tag

import org.springframework.data.relational.core.mapping.Table

@Table("tag")
data class Tag(
    val id: Long = 0,
    val name: String,
    val url: String
)