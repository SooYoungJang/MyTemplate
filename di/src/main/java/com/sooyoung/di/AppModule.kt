package com.sooyoung.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

}