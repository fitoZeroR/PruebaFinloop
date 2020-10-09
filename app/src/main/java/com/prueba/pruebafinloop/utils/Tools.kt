package com.prueba.pruebafinloop.utils

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*

class Tools {
    companion object {
        fun hideKeyboard(activity: Activity) {
            try {
                val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                Objects.requireNonNull(imm)
                    .hideSoftInputFromWindow(
                        Objects.requireNonNull<View>(activity.currentFocus).windowToken,
                        0
                    )
            } catch (ignored: Exception) {
            }

        }
    }
}