package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_logout.*

class Logout : AppCompatActivity() {

    var period: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        period = FirebaseAuth.getInstance()

        val userData = period!!.currentUser
        output.text = userData?.uid.toString()
        output02.text = userData!!.email

        btnlogout.setOnClickListener {
            period!!.signOut()
            Toast.makeText(this, "Logout Complete", Toast.LENGTH_SHORT).show()

            val it = Intent(this,MainActivity::class.java)
            startActivity(it)
            finish()
        }
    }
}