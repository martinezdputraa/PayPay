package com.martinezdputra.rateconverter.datamodel.response

data class CurrenciesResponse(
    val currencies: Map<String, String>?,
    val success: Boolean = false,
    val terms: String? = null,
    val privacy: String? = null)