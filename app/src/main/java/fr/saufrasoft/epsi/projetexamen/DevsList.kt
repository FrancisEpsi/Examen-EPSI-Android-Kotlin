package fr.saufrasoft.epsi.projetexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DevsList : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devs_list)
        showBtnBack()
        setHeaderTitle("Test")
    }
}