package com.dj.sample.di.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dj.sample.di.repositories.IHelloRepository

class HelloViewModel(val helloRepo : IHelloRepository) : ViewModel() {

    fun sayHelloToKodin() : MutableLiveData<String>{
        return helloRepo.sayHello()
    }
}