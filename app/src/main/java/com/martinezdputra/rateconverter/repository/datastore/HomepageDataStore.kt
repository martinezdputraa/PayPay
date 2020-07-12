package com.martinezdputra.rateconverter.repository.datastore

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import io.reactivex.Observable

interface HomepageDataStore {
    fun getCurrencies(): Observable<CurrenciesResponse>

    fun getLiveConversion(source: String): Observable<LiveConversionResponse>
}