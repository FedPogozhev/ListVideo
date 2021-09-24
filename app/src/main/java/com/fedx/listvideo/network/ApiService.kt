package com.fedx.listvideo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("all.json?api-key=0jwL5KN90VFZy4JXS2e98apKHbYhT643")
    suspend fun getAllMovies():Movies
}

object MoviesApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}