package com.ozi.ukm.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.ozi.ukm.databinding.ActivityLoginBinding
import com.ozi.ukm.homeact
import com.ozi.ukm.profilee


class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {

    private lateinit var binding: ActivityLoginBinding
    private var googleApiClient: GoogleApiClient? = null
    lateinit var sign: SignInButton
    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        binding.signInButton.setOnClickListener {
                val intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
                startActivityForResult(intent, RC_SIGN_IN)
        }


        binding.sign.setOnClickListener {
            val h = Intent(this, homeact::class.java)
            startActivity(h)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        if (result.isSuccess) {
            gotoProfile()
        } else {
            Toast.makeText(applicationContext, "Sign in cancel", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoProfile() {
        val intent = Intent(this, profilee::class.java)
        startActivity(intent)
    }
    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }
}