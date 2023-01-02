package com.example.logindi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logindi.data.User
import com.example.logindi.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user


    fun isLoginValid(user: User): Boolean{
        if (user.username == repo.login().username && user.password == repo.login().password){
            _user.value = repo.login()
            return true
        }else{
            return false
        }
    }
}