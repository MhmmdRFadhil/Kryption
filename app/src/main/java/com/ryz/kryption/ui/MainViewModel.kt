package com.ryz.kryption.ui

import androidx.lifecycle.ViewModel
import com.google.android.material.slider.Slider

class MainViewModel: ViewModel() {
    var result =  ""

    fun encryption(plainText: String, slider: Slider) {
        var c: Char
        var cipherText = ""
        for (i in plainText.indices) {
            c = plainText[i]
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c)
                c -= 'A'.code
                c = (c + slider.value.toInt()).code.mod(26).toChar()
                c += 'A'.code
            }
            cipherText += c
        }
        result = cipherText
    }

    fun decryption(cipherText: String, slider: Slider) {
        var c: Char
        var plainText = ""
        for (i in cipherText.indices) {
            c = cipherText[i]
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c)
                c -= 'A'.code
                c = if ((c - slider.value.toInt()).code < 0)
                    (c - slider.value.toInt())
                else
                    (c - slider.value.toInt()).code.mod(26).toChar()

                c += 'A'.code
                c = Character.toLowerCase(c)
            }
            plainText += c
        }
        result = plainText
    }
}