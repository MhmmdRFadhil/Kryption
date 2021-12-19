package com.ryz.kryption.common

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.core.content.ContextCompat
import com.ryz.kryption.R
import com.ryz.kryption.utils.Items.listSpinner

class SpinnerListener(private val btn: Button, private val spinner: Spinner) :
    AdapterView.OnItemSelectedListener {

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when {
            spinner.getItemAtPosition(spinner.selectedItemPosition).toString() == listSpinner[0] -> {
                btn.apply {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.button_disable))
                    isEnabled = false
                    text = context.getString(R.string.process)
                }
            }
            spinner.getItemAtPosition(spinner.selectedItemPosition).toString() == listSpinner[1] -> {
                btn.apply {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.primaryColor))
                    isEnabled = true
                    text = context.getString(R.string.encryption)
                }
            }
            spinner.getItemAtPosition(spinner.selectedItemPosition).toString() == listSpinner[2] -> {
                btn.apply {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.primaryColor))
                    isEnabled = true
                    text = context.getString(R.string.decryption)
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

}