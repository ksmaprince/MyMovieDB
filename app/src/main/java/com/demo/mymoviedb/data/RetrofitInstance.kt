package com.demo.mymoviedb.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

//    fun getRetrofitInstance(): Retrofit{
//        return Retrofit.Builder()
//            .baseUrl("https://api.themoviedb.org/")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//    }
//
//    fun getMovieService(): MovieService{
//        return getRetrofitInstance().create(MovieService::class.java)
//    }
}