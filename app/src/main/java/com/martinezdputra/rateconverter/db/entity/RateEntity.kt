package com.martinezdputra.rateconverter.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RateEntity(
    @PrimaryKey val source: String,
    @PrimaryKey val target: String,
    @ColumnInfo val rate: Double
)