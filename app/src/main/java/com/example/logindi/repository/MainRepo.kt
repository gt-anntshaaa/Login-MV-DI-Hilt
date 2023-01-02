package com.example.logindi.repository

import com.example.logindi.data.User
import com.example.logindi.util.UiState

interface MainRepo {
    //fun login() : User

    fun login(user: User) : UiState<Pair<User, String>>
}