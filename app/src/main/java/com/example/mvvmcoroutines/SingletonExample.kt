package com.example.mvvmcoroutines

import com.example.mvvmcoroutines.models.User

object SingletonExample {

    val singletonObj : User by lazy {

        User(
            email = "niroshan127@gmail.com",
            username = "devudaya",
            image = "proPic.png"
        )
    }
}