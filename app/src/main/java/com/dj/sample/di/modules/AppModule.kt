package com.dj.sample.di.modules

import com.dj.sample.di.activities.MainActivity
import com.dj.sample.di.activities.NonScopedActivity
import com.dj.sample.di.repositories.HelloRepoImpl
import com.dj.sample.di.repositories.IHelloRepository
import com.dj.sample.di.utils.HelloUtils
import com.dj.sample.di.viewmodel.HelloViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val helloModules = module {

    // single instance of HelloRepository
    single<IHelloRepository> {
        HelloRepoImpl()
    }

    viewModel{   // Returns or binds  ViewModel directly
        HelloViewModel(get())
    }

    factory {  // This creates instance every time
        HelloUtils()
    }

    scope(named<MainActivity>()){
        scoped { HelloViewModel(get()) }
    }
}
