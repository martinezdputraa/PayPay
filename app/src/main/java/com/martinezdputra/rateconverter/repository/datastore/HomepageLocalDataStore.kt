package com.martinezdputra.rateconverter.repository.datastore

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import com.martinezdputra.rateconverter.db.AppDatabase
import io.reactivex.Observable
import javax.inject.Inject

class HomepageLocalDataStore @Inject constructor(private val appDatabase: AppDatabase): HomepageDataStore {
    override fun getCurrencies(): Observable<CurrenciesResponse> {
        return appDatabase.currencyDao().getAll().map { entities ->
            return@map CurrenciesResponse(
                currencies = entities.map { entity -> entity.code to entity.displayString }.toMap(),
                success = true
            )
        }
    }

    override fun getLiveConversion(source: String): Observable<LiveConversionResponse> {
        return appDatabase.rateDao().getAll().map { rates ->
            return@map LiveConversionResponse(
                quotes = rates.map { it.source + it.target to it.rate }.toMap(),
                success = true
            )
        }
    }
}