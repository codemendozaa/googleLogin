package com.codemen.newsvalidator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_google_sing.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        
        
    }
    private fun setupUI() {
        sign_out_button.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        startActivity(GoogleSignIn.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut();
    }
}
