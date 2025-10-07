package com.example.focusito03.model

data class User(
    val id: String?,
    val userId: String,
    val displayName: String,
    val role: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "role" to this.role
        )
    }
}
