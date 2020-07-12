package com.martinezdputra.rateconverter.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.martinezdputra.rateconverter.db.entity.RateEntity

@Dao
interface RateDao {
    @Query("SELECT * FROM RateEntity")
    fun getAll(): List<RateEntity>

    @Query("SELECT * FROM RateEntity WHERE source = :source AND target = :target")
    fun getById(source: String, target: String): RateEntity

    @Insert
    fun insertAll(vararg users: RateEntity)

    @Query("DELETE FROM RateEntity")
    fun nukeTable()
}