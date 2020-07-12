package com.martinezdputra.rateconverter.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.martinezdputra.rateconverter.db.entity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM CurrencyEntity")
    fun getAll(): List<CurrencyEntity>

    @Insert
    fun insertAll(vararg users: CurrencyEntity)

    @Query("DELETE FROM CurrencyEntity")
    fun nukeTable()
}