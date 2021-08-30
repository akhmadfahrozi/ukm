package com.ozi.ukm

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class homeact : AppCompatActivity() {
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    private var datalist = ArrayList<ikon>()
    val main = MainActivity()

    lateinit var ool: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeact)
        ool = findViewById(R.id.nav_view)

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.layout_frame, MainActivity()).commit()
        ool.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home1 -> {
                    fm = supportFragmentManager
                    ft = fm.beginTransaction()
                    ft.replace(R.id.layout_frame, MainActivity()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.Search -> {
                    fm = supportFragmentManager
                    ft = fm.beginTransaction()
                    ft.replace(R.id.layout_frame, lihat_kategori()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.Settings -> {
                    fm = supportFragmentManager
                    ft = fm.beginTransaction()
                    ft.replace(R.id.layout_frame, profile()).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


//    private fun setfragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmenttransisi = fragmentManager.beginTransaction()
//        fragmenttransisi.replace(R.id.layout_frame, fragment)
//        fragmenttransisi.commit()
//    }

}