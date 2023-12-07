package com.example.testcasemagang

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClient {

    private const val BASE_URL = "https://api.rawg.io/api/"
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun <T> createService(serviceClass: Class<T>): T {
        return getClient().create(serviceClass)
    }
    fun getService(): RawgApiService {
        return getClient().create(RawgApiService::class.java)
    }

}
