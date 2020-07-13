package com.martinezdputra.rateconverter.di.module

import androidx.lifecycle.ViewModel
import com.martinezdputra.rateconverter.di.annotation.ViewModelKey
import com.martinezdputra.rateconverter.homepage.HomepageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DomainModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomepageViewModel::class)
    abstract fun bindHomepageViewModel(homepageViewModel: HomepageViewModel): ViewModel
}