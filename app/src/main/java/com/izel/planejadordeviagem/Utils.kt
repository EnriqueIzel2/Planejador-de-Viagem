package com.izel.planejadordeviagem

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.NumberFormat
import java.util.Locale

fun EditText.addCurrencyMask(locale: Locale = Locale("pt", "BR")) {
    this.addTextChangedListener(object : TextWatcher {
        private var isUpdating = false
        private val formatter = NumberFormat.getCurrencyInstance(locale)

        override fun afterTextChanged(p0: Editable?) {
            if (isUpdating) return

            isUpdating = true

            val cleanString = p0.toString().replace("[^0-9]".toRegex(), "")

            val parsed = cleanString.toDoubleOrNull() ?: 0.0
            val amountInCents = parsed / 100.0

            val formatted = formatter.format(amountInCents)

            this@addCurrencyMask.setText(formatted)

            val safeSelectionIndex = formatted.length.coerceAtMost(this@addCurrencyMask.text.length)
            this@addCurrencyMask.setSelection(safeSelectionIndex)

            isUpdating = false
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}