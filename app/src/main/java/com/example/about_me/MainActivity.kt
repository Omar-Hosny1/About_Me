package com.example.about_me

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.doneButton.setOnClickListener{addNickname(it)}
        //setContentView(R.layout.activity_main)
        //val doneBtn: Button = findViewById(R.id.done_button)
        //doneBtn.setOnClickListener {addNickname(it)}
    }
    private fun addNickname(view: View){
        val editText: EditText = binding.nicknameEdit
        val nicknameText: TextView = binding.nicknameText
        val enteredNickname = editText.text
        if(enteredNickname.isEmpty()){
            nicknameText.visibility = View.GONE
            Toast.makeText(this, "Enter a Nickname please", Toast.LENGTH_SHORT).show()
            return
        }

        editText.setText("")
        nicknameText.visibility = View.VISIBLE
        nicknameText.text = enteredNickname
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}