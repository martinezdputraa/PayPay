package com.martinezdputra.rateconverter.homepage

import androidx.lifecycle.MutableLiveData
import com.martinezdputra.rateconverter.core.CoreViewModel
import com.martinezdputra.rateconverter.datamodel.Currency
import com.martinezdputra.rateconverter.repository.repository.HomepageRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomepageViewModel @Inject constructor(private val homepageRepository: HomepageRepository): CoreViewModel() {
    var amount: String? = null
    val currencies = MutableLiveData<List<Currency>>()

    fun fetchCurrencies() {
        compositeDisposable.add(
            homepageRepository.fetchCurrencyData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if(response.success) {
                        response?.currencies?.also { res ->
                            currencies.value = res.map { Currency(it.key, it.value) }
                        }
                    }
                }, {t: Throwable? -> t?.printStackTrace()})
        )
    }
}