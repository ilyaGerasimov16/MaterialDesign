package com.example.materialdesign.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PicturesOfTheDayRetrofitImpl {

    private val baseUrl = "https://api.nasa.gov/"

    fun getRetrofit():PictureOfTheDayAPI {
        val podRetrofitImpl = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
        return podRetrofitImpl.create(PictureOfTheDayAPI::class.java)
    }
}