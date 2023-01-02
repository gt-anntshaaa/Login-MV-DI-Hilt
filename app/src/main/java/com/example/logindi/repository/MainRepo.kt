package com.example.logindi.repository

import com.example.logindi.data.User

interface MainRepo {
    fun login() : User
    //fun login(user: User)
}