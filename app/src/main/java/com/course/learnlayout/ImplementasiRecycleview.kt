package com.course.learnlayout

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.course.learnlayout.adapter.AdapterRecyclerView
import com.course.learnlayout.model.Anggota
import kotlinx.android.synthetic.main.activity_implementasi_recycleview.*
import org.w3c.dom.Text

class ImplementasiRecycleview() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_recycleview)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Lukman", 895363780, R.drawable.logoanime, "Jakarta"))
        listAnggota.add(Anggota("Ananda", 895363780, R.drawable.logoanime, "Jakarta"))
        listAnggota.add(Anggota("Muhamad", 895363780, R.drawable.logoanime, "Jakarta"))
        listAnggota.add(Anggota("Elfa", 895363780, R.drawable.logoanime, "Jakarta"))

        list.adapter = AdapterRecyclerView(this, listAnggota, object : AdapterRecyclerView.OnClickListener{
            override fun detailData(item: Anggota?) {
                Dialog(this@ImplementasiRecycleview).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_list_item)

                    val image = this.findViewById<ImageView>(R.id.image)
                    val nama = this.findViewById<TextView>(R.id.textNama)
                    val nohp = this.findViewById<TextView>(R.id.textNohp)
                    val alamat = this.findViewById<TextView>(R.id.textAlamat)
                    val close = this.findViewById<Button>(R.id.close)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "Nama  : ${item?.nama}"
                    nohp.text = "No hp : ${item?.nohp}"
                    alamat.text = "Alamat : ${item?.alamat}"

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}