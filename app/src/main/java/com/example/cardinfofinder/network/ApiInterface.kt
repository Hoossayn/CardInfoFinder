package com.example.cardinfofinder.network


import com.example.cardinfofinder.model.*

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {



    @GET
    fun getBrand(@Url url:String):Call<Brand>

    @GET
    fun getCountry(@Url url:String):Call<Country>

    @GET
    fun getBank(@Url url:String):Call<Bank>

    @GET
    fun getType(@Url url:String):Call<Type>


    companion object {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://lookup.binlist.net/")
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }




}