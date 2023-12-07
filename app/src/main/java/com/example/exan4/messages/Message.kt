package com.example.exan4.messages

import com.squareup.moshi.Json

data class Message(
    @Json(name = "id")
    val id: Int,
    @Json(name = "owner")
    val owner: String,

    @Json(name = "last_message")
    val lastMessage: String,

    @Json(name = "last_active")
    val lastActive: String,

    @Json(name = "unread_messages")
    val unreadMessages: Int,

    @Json(name = "is_typing")
    val isTyping: Boolean,
//
//    val lastMessageType: LastMessageType
){
//    enum class LastMessageType{
//        TEXT,
//        VOICE,
//        FILE
//    }
}

data class MessageResponse(
    @Json(name = "results")
    val results: List<Message>
)
