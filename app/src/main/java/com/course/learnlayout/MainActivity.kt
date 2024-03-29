package com.course.learnlayout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jumpToWidget(view: View?) {
        val intent = Intent(this@MainActivity, Widget::class.java)
        startActivity(intent)
    }

    fun jumpToImplementListView(view: View) {
        val intent = Intent(this@MainActivity, ImplementasiListView::class.java)
        startActivity(intent)
    }

    fun jumpToImplementRecycleView(view: View) {
        val intent = Intent (this@MainActivity, ImplementasiRecycleview::class.java)
        startActivity(intent)
    }

    fun jumpToLoginActivity(view: View) {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}