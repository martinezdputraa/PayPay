package com.martinezdputra.rateconverter.repository.datastore

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import com.martinezdputra.rateconverter.repository.ApiService
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class HomepageRemoteDataStore @Inject constructor(val apiService: ApiService): HomepageDataStore {

    override fun getCurrencies(): Observable<CurrenciesResponse> {
        return apiService.getCurrencies()
    }

    override fun getLiveConversion(): Observable<LiveConversionResponse> {
        return apiService.getLiveConversion()
    }
}