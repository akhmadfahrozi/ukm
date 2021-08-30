package com.ozi.ukm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozi.ukm.databinding.ActivityMainBinding


class MainActivity : Fragment() {

    private val datalist = ArrayList<ikon>()

    private lateinit var bind: ActivityMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.activity_main, null);
        bind = ActivityMainBinding.inflate(inflater, container, false)
        bind.getRoot()

        datalist.add(
            ikon(
                "kuliner",
                20000.0
            )

        )
        datalist.add(
            ikon(
                "fashion",
                3000.0
            )


        )
        datalist.add(
            ikon(
                "fashion", 40000.0
            )


        )
        datalist.add(
            ikon(
                "fashion",
                100.0
            )


        )
        datalist.add(
            ikon(
                "fashion",10900.0
            )


        )
        datalist.add(
            ikon(
                "kuliner",10.0
            )

        )

        bind.rvIkon.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bind.rvIkon.adapter = adapter(datalist) {
        }
        bind.freashh.setLayoutManager(GridLayoutManager(this.context, 2))
        bind.freashh.setHasFixedSize(true)
        bind.freashh.setOnClickListener {
            val pindah = Intent(context,detail::class.java)
            pindah.putExtra("judul",datalist)
            startActivity(pindah)
        }
        bind.freashh.adapter = freash(datalist) {


        }
        return bind.root
    }
}