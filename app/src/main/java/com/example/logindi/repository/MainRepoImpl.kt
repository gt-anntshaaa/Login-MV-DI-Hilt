package com.example.logindi.repository

import com.example.logindi.data.User
import com.example.logindi.util.UiState

class MainRepoImpl : MainRepo {
    //    override fun login(): User {
//        return User("Anastasya", "yesung2000")
//    }
    override fun login(user: User): UiState<Pair<User, String>> {
        if (user.username == "Anastasya" && user.password == "123456"){
            return UiState.Success(Pair(user, "Login is succesfully"))
        }else{
            return UiState.Failure("Login gagal")
        }
    }
}