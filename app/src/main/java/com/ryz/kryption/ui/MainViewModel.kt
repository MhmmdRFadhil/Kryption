package com.ryz.kryption.ui

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var result = ""

    fun encryption(plainText: String, key: Int): String {
        val offset = key % 26
        if (offset == 0) return plainText

        var d: Char
        val chars = CharArray(plainText.length)

        for ((index, c) in plainText.withIndex()) {
            if (c in 'A'..'Z') {
                d = c + offset
                if (d > 'Z') d -= 26
            } else if (c in 'a'..'z') {
                d = c + offset
                if (d > 'z') d -= 26
            } else {
                d = c
            }
            chars[index] = d
        }
        result = chars.joinToString("")
        return result
    }

    fun decryption(cipherText: String, key: Int): String {
        val offset = 26 - key
        if (offset == 0) return cipherText

        var d: Char
        val chars = CharArray(cipherText.length)

        for ((index, c) in cipherText.withIndex()) {
            if (c in 'A'..'Z') {
                d = c + offset
                if (d > 'Z') d -= 26
            } else if (c in 'a'..'z') {
                d = c + offset
                if (d > 'z') d -= 26
            } else {
                d = c
            }
            chars[index] = d
        }
        result = chars.joinToString("")
        return result
    }
}