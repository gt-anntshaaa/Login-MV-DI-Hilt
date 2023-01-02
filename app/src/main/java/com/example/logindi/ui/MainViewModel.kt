package com.example.logindi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logindi.data.User
import com.example.logindi.repository.MainRepo
import com.example.logindi.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
    private val _login = MutableLiveData<UiState<Pair<User, String>>>()
    val login: LiveData<UiState<Pair<User, String>>> = _login

    fun Login(user: User){
        _login.value = UiState.Loading
        val result = repo.login(user)
        if (result is UiState.Success){
            _login.value = UiState.Success(result.values)
        }else if (result is UiState.Failure){
            _login.value = UiState.Failure(result.error)
        }
    }

//    fun isLoginValid(user: User): Boolean{
//        if (user.username == repo.login().username && user.password == repo.login().password){
//            _login.value = repo.login()
//            return true
//        }else{
//            return false
//        }
//    }
}