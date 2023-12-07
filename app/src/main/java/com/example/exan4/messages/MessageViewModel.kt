package com.example.exan4.messages

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Response

class MessageViewModel: ViewModel() {
    private val _messageFlow = MutableStateFlow<List<Message>>(emptyList())
    val messageFlow: StateFlow<List<Message>> = _messageFlow
    val client = ApiMessage.apiService.fetchMessages("744fa574-a483-43f6-a1d7-c65c87b5d9b2")


    fun addMessage(){
        client.enqueue(object : retrofit2.Callback<MessageResponse>{
            override fun onResponse(
                call: Call<MessageResponse>,
                response: Response<MessageResponse>
            ) {
                if (response.isSuccessful){
                    response.body()
                    d("messageBody", " " + response.body())
                    println("gazaaaaaaaaaaaaaaaaaa")
                }
                else{
                    d("messageBodyNotGood", " " + response.body())
                }
            }

            override fun onFailure(call: Call<MessageResponse>, t: Throwable) {

                println("Trakanaaaaaaa")
                Log.e("falbalalaaaa", " " + t.message)
            }
        })





//        viewModelScope.launch {
//            _messageFlow.value = messageFlow.value.toMutableList().also {
//                it.add(Message(1,"Meliqa Meliqa", "gamarjoja rafer xar?", "4:30",2,true,Message.LastMessageType.TEXT))
//            }
//        }
    }
}