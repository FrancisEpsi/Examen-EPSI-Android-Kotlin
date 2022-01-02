package fr.saufrasoft.epsi.projetexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductList : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        intent.getStringExtra("category_title")?.let {setHeaderTitle(it)}
        showBtnBack()

        val products = arrayListOf<Product>()
        

    }
}