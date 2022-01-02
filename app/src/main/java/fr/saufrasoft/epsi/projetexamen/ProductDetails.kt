package fr.saufrasoft.epsi.projetexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductDetails : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        showBtnBack()

        val productObj = intent.getSerializableExtra("productObj") as Product
        setHeaderTitle(productObj.name)

        val imageViewDetailsProduct = findViewById<ImageView>(R.id.imageViewDetailsProduct)
        val tbDescription = findViewById<TextView>(R.id.textViewDetails_ProductDescription)

        Picasso.get().load(productObj.picture_url).into(imageViewDetailsProduct)
        tbDescription.text = productObj.description

    }
}