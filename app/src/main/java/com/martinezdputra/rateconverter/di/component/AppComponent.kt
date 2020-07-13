package com.martinezdputra.rateconverter.di.component

import android.app.Application
import android.content.Context
import com.martinezdputra.rateconverter.di.annotation.ApplicationScope
import com.martinezdputra.rateconverter.di.module.ApiModule
import com.martinezdputra.rateconverter.di.module.AppModule
import com.martinezdputra.rateconverter.di.module.RepositoryModule
import com.martinezdputra.rateconverter.di.module.ViewModelModule
import com.martinezdputra.rateconverter.homepage.HomepageActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    ApiModule::class,
    RepositoryModule::class
])
@ApplicationScope
interface AppComponent {

    fun getApplicationContext(): Context

    fun getApplication(): Application

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(homepageActivity: HomepageActivity)
}