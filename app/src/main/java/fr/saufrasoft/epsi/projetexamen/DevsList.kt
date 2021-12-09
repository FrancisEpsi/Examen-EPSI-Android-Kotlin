package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DevsList : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devs_list)
        showBtnBack()
        setHeaderTitle(getString(R.string.titleBar_DevsList))

        val btnShowStudent1 = findViewById<Button>(R.id.buttonShowDevProfile1)
        btnShowStudent1.setOnClickListener {btnShowStudent1Click()}
    }

    fun btnShowStudent1Click() {
        val DevInfoIntent = Intent(application, DevInfo::class.java)
        startActivity(DevInfoIntent)
    }
}