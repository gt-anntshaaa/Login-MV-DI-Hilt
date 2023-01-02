package com.example.logindi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.logindi.R
import com.example.logindi.data.User
import com.example.logindi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val username = binding.etUserName.text.toString()
            val password = binding.etPassword.text.toString()

            if (viewModel.isLoginValid(User(username,password))){
                Toast.makeText(this, "login succes", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}