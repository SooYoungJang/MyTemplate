package com.sooyoung.di

import android.content.Context
import androidx.room.Room
import com.sooyoung.data.ticker.local.database.KorbitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): KorbitDatabase = Room.databaseBuilder(
        context,
        KorbitDatabase::class.java,
        "korbit-database",
    ).build()

}