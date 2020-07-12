package com.martinezdputra.rateconverter.repository

import com.martinezdputra.rateconverter.datamodel.response.CurrenciesResponse
import com.martinezdputra.rateconverter.datamodel.response.LiveConversionResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(urlList)
    fun getCurrencies(@Query("access_key") accessKey: String = Companion.accessKey): Observable<CurrenciesResponse>

    @GET(urlLive)
    fun getLiveConversion(@Query("access_key") accessKey: String = Companion.accessKey,
                          @Query("source") source: String? = null,
                          @Query("currencies") currencies: String? = null): Observable<LiveConversionResponse>

    companion object {
        private const val accessKey = "8bb052d3c830d54ba54f6943ada028ee"
        private const val urlList = "list"
        private const val urlLive = "live"
    }
}