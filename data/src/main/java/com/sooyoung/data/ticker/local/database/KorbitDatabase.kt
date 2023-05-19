package com.sooyoung.data.ticker.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sooyoung.data.ticker.local.dao.TickerDao
import com.sooyoung.data.ticker.local.entity.TickerEntity

@Database(entities = [TickerEntity::class], version = 1, exportSchema = true)
abstract class KorbitDatabase: RoomDatabase()  {

    abstract fun tickerDao(): TickerDao
}