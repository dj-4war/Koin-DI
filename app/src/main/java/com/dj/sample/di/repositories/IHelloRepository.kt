package com.dj.sample.di.repositories

import androidx.lifecycle.MutableLiveData

interface IHelloRepository {
    fun sayHello() : MutableLiveData<String>
}