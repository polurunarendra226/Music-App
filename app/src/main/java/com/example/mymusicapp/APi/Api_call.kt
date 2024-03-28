package com.example.mymusicapp.APi

import com.example.mymusicapp.Models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api_call {

    @Headers("X-RapidAPI-Key:76395778d0mshec0475446471c79p107289jsn2a4be4e3ae57",
        "X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
     fun getData(
        @Query("q")
        q:String="eminem"): Call<User>
}