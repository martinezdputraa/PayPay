package com.martinezdputra.rateconverter.repository.repository

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import com.martinezdputra.rateconverter.db.AppDatabase
import com.martinezdputra.rateconverter.db.entity.CurrencyEntity
import com.martinezdputra.rateconverter.db.entity.RateEntity
import com.martinezdputra.rateconverter.repository.AppSharedPreference
import com.martinezdputra.rateconverter.repository.datastore.HomepageLocalDataStore
import com.martinezdputra.rateconverter.repository.datastore.HomepageRemoteDataStore
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomepageRepository @Inject constructor(private val localDataStore: HomepageLocalDataStore,
                                             private val remoteDataStore: HomepageRemoteDataStore,
                                             private val appDatabase: AppDatabase,
                                             private val appSharedPreference: AppSharedPreference) {
    fun fetchCurrencyData(): Observable<CurrenciesResponse> {
        if(!appSharedPreference.checkIfCacheExist("currencies")) {
            return remoteDataStore.getCurrencies()
                .doOnNext(updateCurrencyCache())
        }
        return localDataStore.getCurrencies()
    }

    fun fetchConversionRateData(source: String): Observable<LiveConversionResponse> {
        if(appSharedPreference.isShouldUpdateCache("{$source}_rates", 30)) {
            return remoteDataStore.getLiveConversion(source)
                .doOnNext(updateRateCache(source))
        }
        return localDataStore.getLiveConversion(source)
    }

    private fun updateCurrencyCache() : Consumer<CurrenciesResponse> {
        return Consumer { response ->
            response?.currencies?.also { currencyMap ->
                appSharedPreference.setCacheExist("currencies")

                val currencyEntities = currencyMap.map { CurrencyEntity(it.key, it.value) }.toTypedArray()
                appDatabase.currencyDao().apply {
                    nukeTable()
                    insertAll(*currencyEntities)
                }
            }
        }
    }

    private fun updateRateCache(source: String) : Consumer<LiveConversionResponse> {
        return Consumer { response ->
            response?.quotes?.also { rateMap ->
                appSharedPreference.updateLastFetchMillis("{$source}_rates")

                val rateEntities = rateMap.map {
                    RateEntity(
                        source = it.key.substring(0, 3),
                        target = it.key.substring(3),
                        rate = it.value)
                }.toTypedArray()
                appDatabase.rateDao().insertOrUpdateAll(*rateEntities)
            }
        }
    }
}