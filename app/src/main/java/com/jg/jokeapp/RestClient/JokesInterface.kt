package com.jg.jokeapp.RestClient

import com.jg.jokeapp.Models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JokesInterface {

    @GET("joke/{Categories}")
    fun getJoke(@Path ("Categories")Categories:String?): Call<Joke>

}