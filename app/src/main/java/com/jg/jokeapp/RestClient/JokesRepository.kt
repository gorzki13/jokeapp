package com.jg.jokeapp.RestClient

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jg.jokeapp.Models.Joke
import com.jg.jokeapp.Settings.Setting
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JokesRepository {
    private var joke = MutableLiveData<Joke>()

    fun getJoke():MutableLiveData<Joke>{
        return joke
    }

    val retrofitBuilder: JokesInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiUrl.getUrl())
        .build()
        .create(JokesInterface::class.java)

    fun getSingleJokeFromApi(category: ArrayList<String>){


    }

    fun getSingleJokeFromApi(){

       var path=""
        if(Setting.category!=""){
            path=Setting.category
        }else{
            path="Any"
        }
        Log.e("uri",path)
        val retrofitData= retrofitBuilder.getJoke(path)
        retrofitData.enqueue(object : Callback<Joke?>{
            override fun onResponse(call: Call<Joke?>, response: Response<Joke?>) {

                Log.e("API",response.code().toString())
                val responseBody=response.body()
                joke.postValue(responseBody!!)

            }

            override fun onFailure(call: Call<Joke?>, t: Throwable) {
                Log.e("Api", t.message.toString())
            }

        })
    }



}