package com.example.focusito03.model

data class User(
    val id: String?,
    val userId: String,
    val displayName: String,
    val role: String,
    val avatar: String,
    val score: Int
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "role" to this.role,
            "avatar" to this.avatar,
            "score" to this.score
        )
    }
}
