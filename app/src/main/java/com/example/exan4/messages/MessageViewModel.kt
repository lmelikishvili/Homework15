package com.example.exan4.messages

import android.support.v4.os.IResultReceiver._Parcel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel: ViewModel() {
    private val _messageFlow = MutableStateFlow<List<Message>>(emptyList())
    val messageFlow: StateFlow<List<Message>> = _messageFlow


    fun addMessage(){
        viewModelScope.launch {
            _messageFlow.value = messageFlow.value.toMutableList().also {
                it.add(Message(1,"Meliqa Meliqa", "gamarjoja rafer xar?", "4:30",2,true,Message.LastMessageType.TEXT))
            }
        }
    }
}