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
        val btnImageCredits = findViewById<Button>(R.id.buttonCredits)
        val btnRateApp = findViewById<Button>(R.id.buttonRateApp)

        btnDevInfo.setOnClickListener{ btnDevInfoClick() }
        btnUseAPI.setOnClickListener{ btnUseAPIClick() }
        btnImageCredits.setOnClickListener{ btnImageCreditsClick() }
        btnRateApp.setOnClickListener{ btnRateAppClick() }

    }

    private fun btnDevInfoClick() {
        val newIntent = Intent(application,DevsList::class.java)
        startActivity(newIntent)

    }

    private fun btnUseAPIClick() {
        val newIntent = Intent(application,CategoryList::class.java)
        startActivity(newIntent)
    }

    private fun btnImageCreditsClick() {
        val newIntent = Intent(application,ImageCreditsActivity::class.java)
        startActivity(newIntent)
    }

    private fun btnRateAppClick() {
        val newIntent = Intent(application,RateAppActivity::class.java)
        startActivity(newIntent)
    }
}