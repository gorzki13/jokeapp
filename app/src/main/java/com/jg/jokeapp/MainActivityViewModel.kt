package com.jg.jokeapp

import androidx.lifecycle.ViewModel
import com.jg.jokeapp.RestClient.JokesRepository


class MainActivityViewModel :ViewModel(){
  private  val jR= JokesRepository()
    var joke=jR.getJoke()

    fun getNewJoke(){
        jR.getSingleJokeFromApi()
    }


}