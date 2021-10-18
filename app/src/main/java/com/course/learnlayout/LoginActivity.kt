package com.course.learnlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        buttonLogin.setOnClickListener {

            val dataLogin = ModelLogin(textUsername.text.toString(), textPassword.text.toString())

            val intent = Intent(this, ImplicitIntent::class.java)
            intent.putExtra("data", dataLogin)
            startActivity(intent)
            finish()
        }
    }
}