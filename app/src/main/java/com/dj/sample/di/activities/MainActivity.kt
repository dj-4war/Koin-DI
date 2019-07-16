package com.dj.sample.di.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dj.sample.di.R
import com.dj.sample.di.utils.HelloUtils
import com.dj.sample.di.viewmodel.HelloViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // inject MyScopePresenter from current scope
    val scopePresenter: HelloViewModel by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeForData()
        navigate_me.setOnClickListener {
            startActivity(Intent(this@MainActivity, NonScopedActivity::class.java))
        }
    }

    private fun observeForData() {
        getViewModel<HelloViewModel>().sayHelloToKodin().observe(this, Observer<String> { data ->
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        })
        val utils: HelloUtils = get()
        Log.d("MainActivity :: ", utils.currectDate())
    }
}