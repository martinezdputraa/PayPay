package com.martinezdputra.rateconverter.repository.datastore

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import io.reactivex.Observable
import javax.inject.Inject

class HomepageLocalDataStore @Inject constructor(): HomepageDataStore {
    override fun getCurrencies(): Observable<CurrenciesResponse> {
        TODO("Not yet implemented")
    }

    override fun getLiveConversion(): Observable<LiveConversionResponse> {
        TODO("Not yet implemented")
    }
}