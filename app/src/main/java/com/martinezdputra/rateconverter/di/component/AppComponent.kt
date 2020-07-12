package com.martinezdputra.rateconverter.di.component

import com.martinezdputra.rateconverter.di.annotation.ApplicationScope
import com.martinezdputra.rateconverter.di.module.ApiModule
import com.martinezdputra.rateconverter.di.module.ViewModelModule
import com.martinezdputra.rateconverter.homepage.HomepageActivity
import dagger.Component

@Component(modules = [
    ApiModule::class,
    ViewModelModule::class
])
@ApplicationScope
interface AppComponent {
    fun inject(homepageActivity: HomepageActivity)
}