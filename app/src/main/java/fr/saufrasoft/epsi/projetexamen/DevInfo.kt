package fr.saufrasoft.epsi.projetexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

import android.content.ActivityNotFoundException

import android.content.Intent
import android.net.Uri


class DevInfo : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_info)

        showBtnBack()
        setHeaderTitle(getString(R.string.titleBar_DevInfo))

        val linkTextViewEPSI = findViewById<TextView>(R.id.linkTextViewEPSI)
        linkTextViewEPSI.setOnClickListener {

            try {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.linkEPSI).replace("<u>", "").replace("</u>", "")))
                startActivity(webIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this, getString(R.string.errorLinkViewEPSI), Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
            }

        }
    }


}