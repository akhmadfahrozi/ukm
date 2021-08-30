package com.ozi.ukm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter ( private var data: List<ikon>,
private val Listener: (ikon) -> Unit
) : RecyclerView.Adapter<adapter.ViewHolder>() {
    lateinit var contextadapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutinfaler = LayoutInflater.from(parent.context)
        contextadapter=parent.context
        val inflaed =layoutinfaler.inflate(R.layout.activity_kategori,parent,false)
        return ViewHolder(inflaed)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Binditem(data[position],Listener,contextadapter)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tv_title: ImageView = view.findViewById(R.id.img)
        private var date: TextView = view.findViewById(R.id.text1)


        fun Binditem(data: ikon, listener: (ikon) -> Unit, context: Context) {


            date.setText(data.desc)

            //ketika di klik dia bisa ke class membawa data
            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

    override fun getItemCount(): Int = data.size


}