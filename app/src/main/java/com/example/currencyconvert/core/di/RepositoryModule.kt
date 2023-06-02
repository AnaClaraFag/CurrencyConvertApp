package com.example.currencyconvert.core.di

import com.example.currencyconvert.core.data.repository.CurrencyRepository
import com.example.currencyconvert.core.data.repository.ICurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class Module {

    @Binds
    @Singleton
    abstract fun providesPeekManager(m: CurrencyRepository): ICurrencyRepository

}