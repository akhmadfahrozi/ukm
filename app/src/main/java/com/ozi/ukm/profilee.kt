package com.ozi.ukm

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.ozi.ukm.databinding.ActivityProfileeBinding
import com.ozi.ukm.ui.login.LoginActivity


class profilee : AppCompatActivity(),GoogleApiClient.OnConnectionFailedListener {

    private lateinit var binding: ActivityProfileeBinding
    private var googleApiClient: GoogleApiClient? = null
    private var gso: GoogleSignInOptions? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()


        binding.logoutBtn.setOnClickListener{

                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                    object : ResultCallback<Status?> {
                        override fun onResult(p0: Status?) {
                            if (p0!!.isSuccess()) {
                                gotoMainActivity()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Session not close",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }




                    })

        }
    }
    override fun onStart() {
        super.onStart()
        val opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient)
        if (opr.isDone) {
            val result = opr.get()
            handleSignInResult(result)
        } else {
            opr.setResultCallback { googleSignInResult -> handleSignInResult(googleSignInResult) }
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        if (result.isSuccess) {
            val account = result.signInAccount
            binding.name.setText(account.displayName)
            binding.email.setText(account.email)
            binding.userId.setText(account.id)
            try {
                Glide.with(this).load(account.photoUrl).into(binding.profileImage)
            } catch (e: NullPointerException) {
                Toast.makeText(applicationContext, "image not found", Toast.LENGTH_LONG).show()
            }
        } else {
            gotoMainActivity()
        }
    }

    private fun gotoMainActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    override fun onConnectionFailed(p0: ConnectionResult) {

    }
}




