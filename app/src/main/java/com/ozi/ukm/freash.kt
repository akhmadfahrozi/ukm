package com.ozi.ukm

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*

class freash ( private var data: List<ikon>,
               private val Listener: (ikon) -> Unit
) : RecyclerView.Adapter<freash.ViewHolder>() {
    lateinit var contextadapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutinfaler = LayoutInflater.from(parent.context)
        contextadapter=parent.context
        val inflaed =layoutinfaler.inflate(R.layout.activity_freash,parent,false)
        return ViewHolder(inflaed)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Binditem(data[position],Listener,contextadapter)
        holder.itemView.setOnClickListener {
            val pindah = Intent(holder.itemView.context, detail::class.java)
            holder.itemView.getContext().startActivity(pindah)

        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tv_title: TextView = view.findViewById(R.id.hargaaa)
        private var date: TextView = view.findViewById(R.id.namaaa)


        fun Binditem(data: ikon, listener: (ikon) -> Unit, context: Context) {


            date.setText(data.desc)



            val localId = Locale("id", "ID")
            val formatrupiah = NumberFormat.getCurrencyInstance(localId)
                tv_title.setText(formatrupiah.format(data.harga))


            //ketika di klik dia bisa ke class membawa data

        }
    }

    override fun getItemCount(): Int = data.size


}