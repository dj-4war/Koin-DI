package com.dj.sample.di.repositories

import androidx.lifecycle.MutableLiveData

class HelloRepoImpl  : IHelloRepository{
    override fun sayHello() : MutableLiveData<String> {
        val helloMutableLD = MutableLiveData<String>()
        helloMutableLD.value = "Hello Koin"
        return helloMutableLD
    }
}