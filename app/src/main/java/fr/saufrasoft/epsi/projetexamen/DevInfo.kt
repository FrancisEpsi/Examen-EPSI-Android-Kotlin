package fr.saufrasoft.epsi.projetexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DevInfo : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_info)

        showBtnBack()
        setHeaderTitle(getString(R.string.titleBar_DevInfo))

    }

}