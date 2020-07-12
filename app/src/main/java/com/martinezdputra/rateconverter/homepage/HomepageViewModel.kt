package com.martinezdputra.rateconverter.homepage

import androidx.lifecycle.MutableLiveData
import com.martinezdputra.rateconverter.core.CoreViewModel
import com.martinezdputra.rateconverter.datamodel.Currency
import com.martinezdputra.rateconverter.datamodel.Rate
import com.martinezdputra.rateconverter.repository.repository.HomepageRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomepageViewModel @Inject constructor(private val homepageRepository: HomepageRepository): CoreViewModel() {
    var inputAmount: String? = null
    val currencies = MutableLiveData<List<Currency>>()
    val rates = MutableLiveData<List<Rate>>()
    val errorMessage = MutableLiveData<String>()
    var selectedCurrency: Currency = Currency("USD", "United States Dollar")

    fun fetchCurrencies() {
        compositeDisposable.add(
            homepageRepository.fetchCurrencyData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if(response.success) {
                        response?.currencies?.also { res ->
                            val value = res.map { Currency(it.key, it.value) }
                            currencies.value = value
                            selectedCurrency = value[0]
                        }
                    }
                }, {t: Throwable? -> t?.printStackTrace()})
        )
    }

    fun fetchConversionRates() {
        if(inputAmount != null) {
            compositeDisposable.add(
                homepageRepository.fetchConversionRateData(selectedCurrency.code)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        if(response.success) {
                            response.quotes?.also { res ->
                                rates.value = res.map { Rate(
                                    sourceCurrency = selectedCurrency,
                                    targetCurrency = getCurrencyFromCode(it.key.substring(3)),
                                    rate = it.value,
                                    amountAfterConversion = getAmountAfterConversion(it.value)
                                )}
                            }
                        } else {
                            response.error?.also {
                                errorMessage.value = it.info
                            }
                        }
                    }, {t: Throwable? -> t?.printStackTrace()})
            )
        }
    }

    private fun getCurrencyFromCode(code: String): Currency? {
        return currencies.value?.find { it.code == code }
    }

    private fun getAmountAfterConversion(rate: Double): Double {
        val doubleAmount: Double? = inputAmount?.toDoubleOrNull()
        doubleAmount?.also {
            return it * rate
        }
        return rate
    }
}