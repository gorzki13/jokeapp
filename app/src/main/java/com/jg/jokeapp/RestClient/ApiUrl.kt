package com.jg.jokeapp.RestClient

object ApiUrl {

  private var url="https://v2.jokeapi.dev"

    fun getUrl():String{ return url }

    fun setUrl(url:String){ this.url=url }
}