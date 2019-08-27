package com.ar.mvvmtest.ui.quotes

import androidx.lifecycle.ViewModel
import com.ar.mvvmtest.data.Quote
import com.ar.mvvmtest.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuote()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}