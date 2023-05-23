package com.jg.jokeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jg.jokeapp.Settings.SettingsDialog

import com.jg.jokeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settingsDialog= SettingsDialog()
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getNewJoke()
        viewModel.joke.observe(this){

            binding.tVcategory.text=it.category
           if(it.type=="single") {
               binding.tVjoke.text = it.joke
           }
           else {
               binding.tVjoke.text=it.setup+"\n\n\n\n\n"+it.delivery
           }
        }


        binding.bShowNext.setOnClickListener(){
            viewModel.getNewJoke()
        }
        binding.iVSettings.setOnClickListener(){
       settingsDialog.showSettingsDialog(this)
        }

    }
}