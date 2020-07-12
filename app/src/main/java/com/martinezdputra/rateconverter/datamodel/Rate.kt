package com.martinezdputra.rateconverter.datamodel

data class Rate(
    val sourceCurrency: Currency,
    val targetCurrency: Currency?,
    val rate: Double = .0,
    val amountAfterConversion: Double = .0
)