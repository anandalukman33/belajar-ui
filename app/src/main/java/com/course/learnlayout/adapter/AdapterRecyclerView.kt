package com.course.learnlayout.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.course.learnlayout.R
import com.course.learnlayout.model.Anggota
import org.w3c.dom.Text

class AdapterRecyclerView (
    private val context: Context,
    private val data: ArrayList<Anggota>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        return view
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?: 0)
        holder.nama.text = item?.nama


        holder.view.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val nama: TextView = view.findViewById<TextView>(R.id.nama)
        val foto: ImageView = view.findViewById<ImageView>(R.id.image_view)

    }

    interface OnClickListener {
        fun detailData(item: Anggota?)
    }

}