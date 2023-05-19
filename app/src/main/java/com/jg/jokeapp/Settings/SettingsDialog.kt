package com.jg.jokeapp.Settings

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ArrayAdapter
import com.jg.jokeapp.databinding.DialogSettingsBinding


class SettingsDialog {




   private val options = arrayOf("Any","Programming","Miscellaneous","Dark","Pun","Spooky","Christmas")




    fun showSettingsDialog(context:Context) {



        val dialog = Dialog(context)
        val binding = DialogSettingsBinding.inflate(LayoutInflater.from(context))
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val lWindowParams = WindowManager.LayoutParams()
        lWindowParams.copyFrom(dialog.window!!.attributes)
        lWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lWindowParams

        binding.spinnerCategory.adapter = adapter
        binding.spinnerCategory.setSelection(0)


        binding.bSave.setOnClickListener() {

            Setting.settingCategory(binding.spinnerCategory.selectedItem.toString())



            dialog.dismiss()
        }
        dialog.show()

    }}