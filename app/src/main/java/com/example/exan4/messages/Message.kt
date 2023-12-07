package com.example.exan4.messages

import com.squareup.moshi.Json

data class Message(
    @Json(name = "id")
    val id: Int,
    @Json(name = "owner")
    val owner: String,

    val lastMessage: String,

    val lastActive: String,

    val unreadMessages: Int,

    val isTyping: Boolean,

    val lastMessageType: LastMessageType
){
    enum class LastMessageType{
        TEXT,
        VOICE,
        FILE
    }
}

data class MessageResponse(
    @Json(name = "results")
    val results: List<Message>
)
