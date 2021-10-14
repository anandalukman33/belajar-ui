package com.course.learnlayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.course.learnlayout.R
import com.course.learnlayout.model.Anggota

class ListViewAdapter  (private val context: Context, private val data: List<Anggota>?) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        val nama: TextView = view.findViewById<TextView>(R.id.nama)
        val foto: ImageView = view.findViewById<ImageView>(R.id.image_view)

        val item: Anggota? = data?.get(position)

        nama.text = item?.nama
        foto.setImageResource(item?.foto ?: 0)

        return view
    }

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: ""
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = data?.size?: 0
}