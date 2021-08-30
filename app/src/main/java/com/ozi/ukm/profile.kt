package com.ozi.ukm

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ozi.ukm.databinding.ActivityDialoggBinding
import com.ozi.ukm.databinding.ActivityProfileBinding


class profile : Fragment() {
    lateinit var b: TextView
    private lateinit var bind: ActivityProfileBinding
    private lateinit var bind1: ActivityDialoggBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        bind = ActivityProfileBinding.inflate(inflater, container, false)
        bind.getRoot()

        bind.button.setOnClickListener {
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog, null)
            //AlertDialogBuilder
                .findViewById<TextView>(R.id.namahsil)

            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)
                .setTitle("Login Form")


            //show dialog
            mBuilder.show()


        }



        return bind.root
    }


}


