package com.sooyoung.data.ticker.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sooyoung.data.ticker.local.entity.TickerEntity
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface TickerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTickerEntity(tickerEntities: List<TickerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTickerEntity(recordEntity: TickerEntity)

    @Query("SELECT * FROM tickerentity")
    fun getAllTickerEntity(): Flow<List<TickerEntity>>

    @Query(" SELECT * FROM tickerentity WHERE currencyPair = :currencyPair")
    fun getTickerEntity(currencyPair: String): Flow<TickerEntity>

    @Query("DELETE FROM tickerentity")
    suspend fun deleteAllTickerEntity()

}