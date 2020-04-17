package com.example.mvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.userLiveDate.observe(this, Observer {
            println("DEBUG USER: $it")
        })
        mainViewModel.setUserId("1")

        println("DEBUG SINGLETON OBJ: ${SingletonExample.singletonObj}")
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.cancelJobs()
    }
}
