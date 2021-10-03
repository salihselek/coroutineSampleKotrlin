package com.example.coroutinesamplekotlin.netwwork

import com.example.coroutinesamplekotlin.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET(value = "repositories")
    suspend fun getDataFromApi(@Query(value = "q") query: String): RecyclerList
}