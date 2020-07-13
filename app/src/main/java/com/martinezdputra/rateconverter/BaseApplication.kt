package com.martinezdputra.rateconverter

import android.app.Application
import com.martinezdputra.rateconverter.di.component.DaggerAppComponent

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }
}