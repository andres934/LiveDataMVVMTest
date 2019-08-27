package com.ar.mvvmtest.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ar.mvvmtest.R
import com.ar.mvvmtest.data.Quote
import com.ar.mvvmtest.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUI()
    }

    private fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            tvInfo.text = stringBuilder.toString()
        })

        btnAddQuote.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuote(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }
    }
}
