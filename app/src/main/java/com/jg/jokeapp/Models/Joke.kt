package com.jg.jokeapp.Models

import java.io.Serializable

class Joke constructor(var error:Boolean,
            var category:String,
            var type:String,
            var joke:String,
            var setup:String,
            var delivery:String,
            var flags:Flags,
            var id:String,
            var safe:String,
            var lang:String
            ):Serializable{}
