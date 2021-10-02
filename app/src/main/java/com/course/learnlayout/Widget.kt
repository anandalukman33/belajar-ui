package com.course.learnlayout

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_widget.*

class Widget : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah toast", Toast.LENGTH_SHORT).show()
        }

        buttonSnackBar.setOnClickListener {
            Snackbar.make(it,"Ini adalah SnackBar",Snackbar.LENGTH_LONG).show()
        }

        buttonAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Judul Custom Dialog")
                setMessage("Ini adalah Alert")
                setPositiveButton("OK") { dialog, _ ->
                    Toast.makeText(applicationContext, "Kamu klik OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("CANCEL") { dialog, _ ->
                    Toast.makeText(applicationContext, "Kamu klik CANCEL", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }.show()
            }
        }

        buttonCustom.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.dialog_custom)

                val btnCancel = this.findViewById<Button>(R.id.buttonCancel)
                val btnConfirm = this.findViewById<Button>(R.id.buttonConfirm)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Kamu Klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnConfirm.setOnClickListener {
                    Toast.makeText(applicationContext, "Kamu klik Confirm", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }
    }
}