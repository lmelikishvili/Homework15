package com.example.exan4.messages

data class Message(
    val id: Int,
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
