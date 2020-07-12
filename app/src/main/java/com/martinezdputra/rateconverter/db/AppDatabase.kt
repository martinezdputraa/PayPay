package com.martinezdputra.rateconverter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.martinezdputra.rateconverter.db.dao.CurrencyDao
import com.martinezdputra.rateconverter.db.dao.RateDao
import com.martinezdputra.rateconverter.db.entity.CurrencyEntity
import com.martinezdputra.rateconverter.db.entity.RateEntity

@Database(entities = [CurrencyEntity::class, RateEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao

    abstract fun rateDao(): RateDao
}