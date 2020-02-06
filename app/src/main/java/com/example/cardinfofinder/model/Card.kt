package com.example.cardinfofinder.model





    data class Brand(val brand: String)
    data class Type(val type: String)
    data class Country(
        val name: String,
        val emoji: String,
        val latitude: String,
        val longitude: String
    )

    data class Bank(val name: String, val url: String, val phone: String, val city: String)

