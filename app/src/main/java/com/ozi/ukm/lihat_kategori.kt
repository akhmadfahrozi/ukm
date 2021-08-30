package com.ozi.ukm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozi.ukm.databinding.ActivityLihatKategoriBinding
import com.ozi.ukm.databinding.ActivityMainBinding


class lihat_kategori : Fragment() {
    private val datalist = ArrayList<ikon>()

    private lateinit var bind: ActivityLihatKategoriBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.activity_main, null);
        bind = ActivityLihatKategoriBinding.inflate(inflater, container, false)
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

        bind.lihat.setLayoutManager(GridLayoutManager(this.context, 2))
        bind.lihat.setHasFixedSize(true)

        bind.lihat.adapter = freash(datalist) {


        }
        return bind.root
    }
}