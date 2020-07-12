package com.martinezdputra.rateconverter.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class CoreViewModel: ViewModel() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}