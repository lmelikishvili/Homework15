package com.example.exan4.messages

import android.support.v4.os.IResultReceiver._Parcel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MessageViewModel: ViewModel() {
    private val _messageFlow = MutableStateFlow<List<Message>>(emptyList())
    val messageFlow: StateFlow<List<Message>> = _messageFlow
    val messages = mutableListOf<Message>(
        Message(1,"Meliqa Meliqa", "gamarjoja rafer xar?", "4:30",2,true,Message.LastMessageType.TEXT)
    )

//    fun addMessage(){
//        _messageFlow.value = messageFlow.value.toMutableList().also {
//            it.add(Message(1,"Meliqa Meliqa", "gamarjoja rafer xar?", "4:30",2,true,Message.LastMessageType.TEXT))
//        }
//    }

}