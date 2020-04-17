package com.example.mvvmcoroutines.repository

import androidx.lifecycle.LiveData
import com.example.mvvmcoroutines.api.RetrofitFactory
import com.example.mvvmcoroutines.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainRepository {

    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User> {

        job = Job()
        return object : LiveData<User>() {

            override fun onActive() {

                super.onActive()
                job?.let { theJOb ->
                    CoroutineScope(IO + theJOb).launch {
                        val user = RetrofitFactory.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            theJOb.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() {
        job?.cancel()
    }
}