package com.martinezdputra.rateconverter.di.module

import android.app.Application
import android.content.Context
import com.martinezdputra.rateconverter.di.annotation.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    @ApplicationScope
    fun providesApplicationContext(app: Application): Context = app.applicationContext
}