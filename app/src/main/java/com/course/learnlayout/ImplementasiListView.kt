package com.course.learnlayout

import android.app.Dialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.course.learnlayout.adapter.ListViewAdapter
import com.course.learnlayout.model.Anggota
import kotlinx.android.synthetic.main.activity_implementasi_listview.*
import org.w3c.dom.Text

class ImplementasiListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_listview)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Lukman", 8345678, R.drawable.logoanime, "Jakarta"))
        listAnggota.add(Anggota("Ananda", 8345678, R.drawable.logoanime, "Ciputat"))
        listAnggota.add(Anggota("Muhamad", 8345678, R.drawable.logoanime, "Pamulang"))
        listAnggota.add(Anggota("Afureru", 8345678, R.drawable.logoanime, "Kolong Jembatan"))

        val adapter = ListViewAdapter(this, listAnggota)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->

            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list_item)

                val image = this.findViewById<ImageView>(R.id.image)
                val nama = this.findViewById<TextView>(R.id.textNama)
                val nohp = this.findViewById<TextView>(R.id.textNohp)
                val alamat = this.findViewById<TextView>(R.id.textAlamat)
                val close = this.findViewById<Button>(R.id.close)

                val item = listAnggota.get(position)

                image.setImageResource(item.foto)
                nama.text = "Nama : ${item.nama}"
                nohp.text = "Nama : ${item.nohp}"
                alamat.text = "Nama : ${item.alamat}"

                close.setOnClickListener {
                    this.dismiss()
                }
            }.show()
        }
    }
}