package com.example.app.network

import com.example.app.models.Maqollar
import com.example.app.models.Ruknlar
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("https://maqollar.uz/wp-json/wp/v2/posts")
    fun getAllMaqollar(): Call<List<Maqollar>>
}