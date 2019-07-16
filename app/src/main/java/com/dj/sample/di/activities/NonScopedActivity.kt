package com.dj.sample.di.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dj.sample.di.utils.HelloUtils
import com.dj.sample.di.viewmodel.HelloViewModel
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.getViewModel

class NonScopedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        observeForData()
    }

    private fun observeForData() {
        getViewModel<HelloViewModel>().sayHelloToKodin().observe(this, Observer<String> { data ->
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        })
        val utils: HelloUtils = get()
        Log.d("MainActivity :: ", utils.currectDate())
    }
}