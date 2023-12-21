package com.dicoding.appcapstone.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CalorieNinjaApiClient {
    private val BASE_URL = "https://api.calorieninjas.com/"
    private val API_KEY = "07xtjoEQQLRL9fWB9Ik5XVLrKgTCN8Pi2aNRd8WK"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Api-Key", API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: CalorieNinjaApiService = retrofit.create(CalorieNinjaApiService::class.java)
}
