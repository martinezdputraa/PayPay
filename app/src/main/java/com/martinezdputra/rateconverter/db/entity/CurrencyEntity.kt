package com.martinezdputra.rateconverter.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyEntity(
    @PrimaryKey val code: String,
    @ColumnInfo(name = "display_string") val displayString: String
)