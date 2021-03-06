package com.example.mvvmcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.mvvmcoroutines.models.User
import com.example.mvvmcoroutines.repository.MainRepository

class MainViewModel : ViewModel() {

    private val _userId: MutableLiveData<String> = MutableLiveData()

    val userLiveDate: LiveData<User> = Transformations.switchMap(_userId) {
        MainRepository.getUser(it)
    }

    fun setUserId(userId: String) {

        if (_userId.value == userId)
            return
        _userId.value = userId
    }

    fun cancelJobs() {
        MainRepository.cancelJobs()
    }
}