package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import android.util.TypedValue
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

        if (txt.length > 100) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 8F)
        } else if (txt.length > 60) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12F)
        } else if (txt.length > 30) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16F)
        } else if (txt.length > 20) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F)
        } else if (txt.length > 15) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 26F)
        } else if (txt.length > 10) {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32F)
        } else {
            titleBar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40F)
        }

        titleBar.text = txt
    }

}