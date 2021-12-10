package fr.saufrasoft.epsi.projetexamen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (private val Categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val tbCategoryTitle = view.findViewById<TextView>(R.id.textViewCategoryTitle)
        val layoutItemRow = view.findViewById<LinearLayout>(R.id.categoryItemRowLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_category_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorieItem = Categories.get(position)
        holder.tbCategoryTitle.text = categorieItem.title
    }

    override fun getItemCount(): Int {
        return Categories.count()
    }

}