package fr.saufrasoft.epsi.projetexamen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


//On spécifie une liste de Category en argument d'instanciation (dans la méthode d'appel) de la classe:
class CategoryAdapter (private val Categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        //On récupère les contrôles dans des variables.
        // (!) Toutes la variables ici seront disponibles en appellant le ViewHolder:
        val tbCategoryTitle = view.findViewById<TextView>(R.id.textViewCategoryTitle)
        val layoutItemRow = view.findViewById<LinearLayout>(R.id.categoryItemRowLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_category_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Cette fonction est appelé à chaque élément dans notre liste de Category "Categories"

        val categorieItem = Categories.get(position) //On récupère l'élément en cours de traitement dans la liste grâce à son index pour pouvoir lire ces propriétées
        holder.tbCategoryTitle.text = categorieItem.title //Comme le titre qu'on affichera sur la vue.

        holder.layoutItemRow.setOnClickListener(View.OnClickListener {
            //M'a donner beaucoup de fil a retordre pour pouvoir instancier une Intent et la démarrer depuis ICI. Malgré mes recherches sur Internet je n'ai pas réelement trouver de solution à mon problème mais j'ai finit pas tenter ça et ça fonctionne donc je ne touche plus !:
            //(Vous nous avez pas vraiment expliquer ce que c'était "Application" lors de l'instanciation d'une Intent comme d'habitude avec Intent(Application, ProductList::class.java)

            //val newProductIntent = Intent(holder.layoutItemRow.rootView.context, ProductList::class.java)
            val newProductIntent = Intent(holder.layoutItemRow.context, ProductList::class.java)
            newProductIntent.putExtra("category_title", categorieItem.title)
            newProductIntent.putExtra("category_productURL", categorieItem.product_url)
            holder.layoutItemRow.context.startActivity(newProductIntent)



        })


    }


    override fun getItemCount(): Int {
        return Categories.count()
    }

}