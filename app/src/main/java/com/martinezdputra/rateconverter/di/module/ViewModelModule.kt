package com.martinezdputra.rateconverter.di.module

import androidx.lifecycle.ViewModelProvider
import com.martinezdputra.rateconverter.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}