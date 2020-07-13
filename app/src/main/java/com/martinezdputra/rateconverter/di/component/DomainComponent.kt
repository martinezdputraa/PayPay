package com.martinezdputra.rateconverter.di.component

import com.martinezdputra.rateconverter.di.annotation.ScreenScope
import com.martinezdputra.rateconverter.di.module.DomainModule
import com.martinezdputra.rateconverter.homepage.HomepageActivity
import dagger.Component

@Component(modules = [
    DomainModule::class
], dependencies = [
    AppComponent::class
])
@ScreenScope
interface DomainComponent {
    fun inject(homepageActivity: HomepageActivity)
}