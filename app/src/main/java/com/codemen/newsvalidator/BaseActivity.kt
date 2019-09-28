package com.codemen.newsvalidator

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.VisibleForTesting

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        @VisibleForTesting
        val progressDialog by lazy {
            ProgressDialog(this)
        }

        fun showProgressDialog() {
            progressDialog.setMessage(getString(R.string.loading))
            progressDialog.isIndeterminate = true
            progressDialog.show()
        }

        fun hideProgressDialog() {
            if (progressDialog.isShowing) {
                progressDialog.dismiss()
            }
        }

        fun hideKeyboard(view: View) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }



    }
}
