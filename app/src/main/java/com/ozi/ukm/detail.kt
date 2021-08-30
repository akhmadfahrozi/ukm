package com.ozi.ukm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ozi.ukm.databinding.ActivityDetailBinding

class detail : AppCompatActivity() {

    private val datalist = ArrayList<ikon>()

    private lateinit var bind: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)


    }
}