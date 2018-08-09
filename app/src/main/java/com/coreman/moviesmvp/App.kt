package com.coreman.moviesmvp

import android.app.Application
import com.coreman.moviesmvp.di.*
import com.coreman.moviesmvp.di.modules.AppModule
import com.coreman.moviesmvp.di.modules.NetworkModule
import com.coreman.moviesmvp.di.modules.PresenterModule

class App : Application() {

    lateinit var mainComponent: MainComponent

    companion object {
        lateinit var instance : App private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule())
                .presenterModule(PresenterModule())
                .build()
    }
}