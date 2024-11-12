package com.tunm17.socialnetworktwitch.domain.models

import java.sql.Timestamp

data class Comment(
    val commentId: Int = -1,
    val username: String = "",
    val profilePictureUrl: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val comment: String = "",
    val isLiked: Boolean = false,
    val likeCount: Int = 12
)
