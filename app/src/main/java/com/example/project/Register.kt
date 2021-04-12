package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.email

class Register : AppCompatActivity() {

    var period: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        period = FirebaseAuth.getInstance()

        if (period!!.currentUser != null) {
            val it = Intent(this, Dataperiod::class.java)
            startActivity(it)
            finish()
        }

        btnregister.setOnClickListener {
            val Email = email.getText().toString().trim()
            val Pass = password.getText().toString().trim()

            if (Email.isEmpty()) {
                Toast.makeText(this, "Please enter your email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (Pass.isEmpty()) {
                Toast.makeText(this, "Please enter your password.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            period!!.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (Pass.length < 6) {
                        password.error = "Password must be 6-16 character."
                    } else {
                        Toast.makeText(this, "Register failed: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Register complete", Toast.LENGTH_SHORT).show()
                    val vName = name.text.toString()
                    val vAge = age.text.toString()
                    val vTel = tel.text.toString()

                    val db = FirebaseDatabase.getInstance()
                    val ref = db.getReference("UData")
                    val id: String? = ref.push().key

                    val UData = UData(id.toString(), vName, vAge, vTel)
                    ref.child(id.toString()).setValue(UData).addOnCompleteListener {
                        Toast.makeText(applicationContext, "Complete", Toast.LENGTH_LONG).show()

                        val it = Intent(this, Dataperiod::class.java)
                        startActivity(it)
                        finish()
                    }
                }
            }
        }
    }
}