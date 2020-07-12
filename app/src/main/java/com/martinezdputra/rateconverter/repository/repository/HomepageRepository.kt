package com.martinezdputra.rateconverter.repository.repository

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.repository.datastore.HomepageLocalDataStore
import com.martinezdputra.rateconverter.repository.datastore.HomepageRemoteDataStore
import io.reactivex.Observable
import javax.inject.Inject

class HomepageRepository @Inject constructor(private val localDataStore: HomepageLocalDataStore,
                                             private val remoteDataStore: HomepageRemoteDataStore) {
    fun fetchCurrencyData(): Observable<CurrenciesResponse> {
        return remoteDataStore.getCurrencies()
    }

    fun getCacheCurrencyData(): Observable<CurrenciesResponse> {
        return localDataStore.getCurrencies()
    }
}