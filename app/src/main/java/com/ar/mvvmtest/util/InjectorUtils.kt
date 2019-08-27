package com.ar.mvvmtest.util

import com.ar.mvvmtest.data.FakeDatabase
import com.ar.mvvmtest.data.QuoteRepository
import com.ar.mvvmtest.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}