package com.martinezdputra.rateconverter.di.component

import android.app.Application
import com.martinezdputra.rateconverter.di.annotation.ApplicationScope
import com.martinezdputra.rateconverter.di.module.ApiModule
import com.martinezdputra.rateconverter.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    ViewModelModule::class,
    ApiModule::class
])
@ApplicationScope
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}