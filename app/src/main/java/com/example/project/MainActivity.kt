package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var period: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text01 = Toast.makeText(applicationContext,"Delete complete", Toast.LENGTH_LONG)

        period = FirebaseAuth.getInstance()

        if (period!!.currentUser!=null){
            val it = Intent(this, Dataperiod::class.java)
            startActivity(it)
            finish()
        }

        btnlogin.setOnClickListener(){
            val Email = email.getText().toString().trim()
            val Pass = password.getText().toString().trim()

            if (Email.isEmpty()){
                Toast.makeText(this, "Please enter your email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(Pass.isEmpty()){
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            period!!.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener{task ->
                if (!task.isSuccessful){
                    if (Pass.length < 6){
                        password.error = "Password must be 8-16 Character"
                    }
                    else{
                        Toast.makeText(this,"Login failed: "+ task.exception!!.message, Toast.LENGTH_LONG).show()
                    }
                } else{
                    Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                    val it = Intent(this, Dataperiod::class.java)
                    startActivity(it)
                    finish()
                }
            }
        }
        btnreset.setOnClickListener(){
            email.setText(null)
            password.setText(null)
            text01.show()
        }

        btnregister.setOnClickListener {
            val it = Intent(this,Register::class.java)
            startActivity(it)
        }
    }
}