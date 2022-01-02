package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class ProductAdapter (private val Products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val layoutProductItemRow = view.findViewById<LinearLayout>(R.id.productItemRowLayout)
        val imageViewProductImage = view.findViewById<ImageView>(R.id.productImageView)
        val tbProductTitle = view.findViewById<TextView>(R.id.textViewProductTitle)
        val tbProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_product_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = Products.get(position)
        holder.tbProductTitle.text = productItem.name


        if (productItem.description.length > 70) {
            val shortDescription : CharSequence = productItem.description.subSequence(0, 69)
            val spaceStr = " ..."
            holder.tbProductDescription.text = "$shortDescription $spaceStr"
        } else {
            holder.tbProductDescription.text = productItem.description
        }


        Picasso.get().load(productItem.picture_url).into(holder.imageViewProductImage)


        holder.layoutProductItemRow.setOnClickListener(View.OnClickListener {
            val newProductDetailsIntent = Intent(holder.layoutProductItemRow.context, ProductDetails::class.java)
            newProductDetailsIntent.putExtra("productObj", productItem)
            holder.layoutProductItemRow.context.startActivity(newProductDetailsIntent)
        })
    }


    override fun getItemCount(): Int {
        return Products.count()
    }

}