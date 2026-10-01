package com.izel.planejadordeviagem

import android.text.InputFilter
import android.text.Spanned
import android.widget.EditText
import java.util.regex.Pattern

fun EditText.limitDecimalDigits(maxDigitsAfterDecimal: Int = 2) {
    val filter = object : InputFilter {
        private val pattern = Pattern.compile(
            "^[0-9]*[.,]?[0-9]{0,$maxDigitsAfterDecimal}$"
        )

        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int
        ): CharSequence? {
            val newText = StringBuilder(dest.toString())
                .replace(dstart, dend, source?.subSequence(start, end).toString())
                .toString()

            val matcher = pattern.matcher(newText)
            return if (matcher.matches()) null else ""
        }
    }

    this.filters = arrayOf(*this.filters, filter)
}