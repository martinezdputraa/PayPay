package com.martinezdputra.rateconverter.db.entity

import androidx.room.Entity

@Entity(primaryKeys = ["source", "target"])
data class RateEntity(
    val source: String,
    val target: String,
    val rate: Double
)