package com.prueba.pruebafinloop.presentation.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prueba.pruebafinloop.R
import com.prueba.pruebafinloop.presentation.framework.network.api.Resource
import com.prueba.pruebafinloop.presentation.utils.showToast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    fun showLoading() {
        progressDialog = ProgressDialog.show(this, "", getString(R.string.prb_cargando), true, false)
    }

    fun hideLoading() {
        progressDialog.dismiss()
    }

    inline fun <T> observerResourcesManager(resource: Resource<T>, genericFunction: () -> Unit) {
        when(resource.status) {
            Resource.Status.LOADING -> showLoading()
            Resource.Status.SUCCESS -> {
                hideLoading()
                genericFunction()
            }
            Resource.Status.ERROR -> {
                hideLoading()
                showToast(resource.message.toString())
            }
        }
    }
}