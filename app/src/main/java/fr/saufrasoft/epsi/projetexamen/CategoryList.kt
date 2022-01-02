package fr.saufrasoft.epsi.projetexamen

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoryList : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        showBtnBack()
        setHeaderTitle(getString(R.string.titleBar_CategoryList))


        val categories = arrayListOf<Category>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val categoryAdapter = CategoryAdapter(categories)
        recyclerView.adapter = categoryAdapter

        //Récupération des catégories via une requête HTTP:
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val reqURL ="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(reqURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if(data !=null){
                    //Traitement des données JSON reçu pour attribuer les objets Category et les ajouter à la liste:
                        val jsObj = JSONObject(data) //Classe JSON permettant le traitement du formattage des données
                        val jsArray = jsObj.getJSONArray("items") //Tableau contenant les catégories formattées en JSON
                        for(i in 0 until jsArray.length()) { //On boucle sur toutes les catégories
                            val jsCategory = jsArray.getJSONObject(i) //Tableau contenant les informations de la catégorie à chaque clé
                            //Création de l'objet catégorie (et instanciation de ses avec leurs valeures):
                            val categoryObj = Category(jsCategory.optInt("category_id", 0),jsCategory.optString("title","unknow"),jsCategory.optString("product_url","unknow"))
                            categories.add(categoryObj)
                        }
                        //Rafraichissement des données dans le RecyclerView par le thread principal:
                    runOnUiThread(Runnable {
                        categoryAdapter.notifyDataSetChanged()
                    })
                }
            }

        })


    }
}