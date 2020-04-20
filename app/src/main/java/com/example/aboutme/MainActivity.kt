package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val myName: MyName= MyName("Zahar Gusyatin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  setContentView(R.layout.activity_main)*/
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName
     /*   btnDone.setOnClickListener{
            addNickName(it)
        }*/
        binding.btnDone.setOnClickListener {
            addNickName(it)
        }

    }
    private fun addNickName(view: View){
        binding.apply {

        /*    binding.textViewSetName.text = binding.nicknameName.text*/
            myName?.nickname=nicknameName.text.toString()
            invalidateAll()
            binding.btnDone.visibility = View.GONE
            binding.nicknameName.visibility = View.GONE
            binding.textViewSetName.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
