package com.example.logindi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.logindi.data.User
import com.example.logindi.databinding.ActivityMainBinding
import com.example.logindi.util.UiState
import com.example.logindi.util.hide
import com.example.logindi.util.show
import com.example.logindi.util.toast
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

            viewModel.Login(User(username,password))
        }

        viewModel.login.observe(this){
            when(it){
                is UiState.Loading -> {binding.progressBar.show()}
                is UiState.Success -> {
                    binding.progressBar.hide()
                    val user = it.values.first
                    toast("${it.values.second}")
                }
                is UiState.Failure -> {
                    toast("${it.error}")
                }
            }
        }
    }
}