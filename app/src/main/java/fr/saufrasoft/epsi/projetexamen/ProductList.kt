package fr.saufrasoft.epsi.projetexamen

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductList : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        intent.getStringExtra("category_title")?.let {setHeaderTitle(it)}
        val productURL : String = intent.getStringExtra("category_productURL").toString()
        showBtnBack()

        val products = arrayListOf<Product>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProduct)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter

        //Récupération des catégories via une requête HTTP:
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(productURL)
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
                    //Traitement des données JSON reçu pour attribuer les objets Product et les ajouter à la liste:
                    val jsObj = JSONObject(data) //Classe JSON permettant le traitement du formattage des données
                    val jsArray = jsObj.getJSONArray("items") //Tableau contenant les produits formattées en JSON
                    for(i in 0 until jsArray.length()) { //On boucle sur toutes les catégories
                        val jsProduct = jsArray.getJSONObject(i) //Tableau contenant les informations du produit à chaque clé
                        //Création de l'objet produit (et instanciation de ses avec leurs valeures):
                        val productObj = Product(jsProduct.optString("name","unknow"),jsProduct.optString("description","unknow"),jsProduct.optString("picture_url","unknow"))
                        products.add(productObj)
                    }
                    //Rafraichissement des données dans le RecyclerView par le thread principal:
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })
                }
            }

        })

    }
}