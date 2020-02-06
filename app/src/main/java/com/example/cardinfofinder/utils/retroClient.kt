package com.example.cardinfofinder.utils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object retroClient {
    private var ourInstance: Retrofit?= null

    val instance: Retrofit
        get() {
            if(ourInstance == null){
                ourInstance = Retrofit.Builder()
                    //"https://lookup.binlist.net/"
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return ourInstance!!

        }

}