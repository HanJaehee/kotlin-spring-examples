package com.hindsight.board.domain.post_tag

import org.springframework.data.relational.core.mapping.Table

@Table("post_tag")
data class PostTag(
    val id: Long = 0,
    val postId: Long,
    val tagId: Long
)
