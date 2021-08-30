package com.ozi.ukm

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class splashscreen : AppCompatActivity() {

    lateinit var top: Animation
    lateinit var nimtop : Animation
    lateinit var imh : ImageView
    lateinit var ig : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

//        imh = findViewById(R.id.l1)
//        ig = findViewById(R.id.l2)
//
//        top = AnimationUtils.loadAnimation(this,R.anim.top_anim)
//        nimtop = AnimationUtils.loadAnimation(this,R.anim.bottom)
//
//        imh.setAnimation(top);
//        ig.setAnimation(nimtop);

        var handler = Handler()
        handler.postDelayed({
            val splsh = Intent(this, homeact::class.java)
            startActivity(splsh)
            finish()

        }, 2000)
    }


}