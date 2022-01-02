package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

open class BaseActivity : AppCompatActivity() {

    fun showBtnBack(){
        val btnBack=findViewById<ImageView>(R.id.imageViewBack)
        btnBack.visibility= View.VISIBLE
        btnBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun setHeaderTitle(txt : String){
        val titleBar = findViewById<TextView>(R.id.textViewTitleBar)
        titleBar.text = txt
    }

}