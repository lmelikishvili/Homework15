package com.example.exan4.messages

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MessageViewModel: ViewModel() {
    private val _messageFlow = MutableStateFlow<List<Message>>(emptyList())
    val messageFlow: StateFlow<List<Message>> = _messageFlow

    fun addMessage(){

        val BASE_URL = "https://run.mocky.io/"
        //val BASE_URL = "https://rickandmortyapi.com/api/"

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        val apiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }

        val client = apiService.fetchMessages()


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