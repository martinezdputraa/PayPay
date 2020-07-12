package com.martinezdputra.rateconverter.datamodel.response

data class LiveConversionResponse (
    val success: Boolean = false,
    val terms: String? = null,
    val privary: String? = null,
    val timestamp: Long = 0,
    val source: String? = null,
    val quotes: Map<String, Float>? = null)