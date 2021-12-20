package com.ryz.kryption.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.ryz.kryption.R
import com.ryz.kryption.common.SpinnerListener
import com.ryz.kryption.databinding.ActivityMainBinding
import com.ryz.kryption.utils.Items.listSpinner
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainPresenter by inject<MainPresenter>()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.app_name)

        mainPresenter.attachView(this)

        initial()
        displayResult()
        binding.btnEncryptionDecryption.setOnClickListener(this@MainActivity)
    }

    private fun initial() {
        val adapterSpinner =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listSpinner)
        binding.apply {
            spinner.adapter = adapterSpinner
            spinner.onItemSelectedListener = SpinnerListener(btnEncryptionDecryption, spinner)
        }
    }

    private fun encryptionText(plainText: String) {
        viewModel.encryption(plainText, binding.slider.value.toInt())
        displayResult()
    }

    private fun decryptionText(cipherText: String) {
        viewModel.decryption(cipherText, binding.slider.value.toInt())
        displayResult()
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result
    }

    override fun onPlainTextEmpty() {
        binding.edtText.error = getString(R.string.empty_plain_text)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_encryption_decryption -> {
                when (binding.btnEncryptionDecryption.text) {
                    getString(R.string.encryption) -> encryptionText(
                        binding.edtText.text.toString().trim()
                    )
                    getString(R.string.decryption) -> decryptionText(
                        binding.edtText.text.toString().trim()
                    )
                }
                mainPresenter.check(binding.edtText.text.toString().trim())
            }
        }
    }
}