package com.example.logindi.repository

import com.example.logindi.data.User

class MainRepoImpl : MainRepo {
    override fun login(): User {
        return User("Anastasya", "yesung2000")
    }

}