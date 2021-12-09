package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val newIntent= Intent(application,MainActivity::class.java)
            startActivity(newIntent)
            finish()
        },2000)
    }
}