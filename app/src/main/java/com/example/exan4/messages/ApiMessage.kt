package com.example.exan4.messages

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object ApiMessage {


}

interface ApiService{
    @GET("v3/744fa574-a483-43f6-a1d7-c65c87b5d9b2")
    fun fetchMessages(): Call<MessageResponse>
    //fun fetchMessages(@Query("page") page: String): Call<MessageResponse>
}