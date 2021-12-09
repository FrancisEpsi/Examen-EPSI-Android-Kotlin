package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDevInfo = findViewById<Button>(R.id.buttonDevInfo)
        val btnUseAPI = findViewById<Button>(R.id.buttonUseAPI)

        btnDevInfo.setOnClickListener{ btnDevInfoClick() }
        btnUseAPI.setOnClickListener{ btnUseAPIClick() }

    }

    private fun btnDevInfoClick() {
        val newIntent = Intent(application,DevsList::class.java)
        startActivity(newIntent)

    }

    private fun btnUseAPIClick() {

    }
}