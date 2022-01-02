package fr.saufrasoft.epsi.projetexamen

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import okhttp3.*
import java.io.IOException

class RateAppActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_app)
        showBtnBack()
        setHeaderTitle(getString(R.string.RateApp_Title))

        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        val btnSubmit = findViewById<Button>(R.id.buttonSubmitRate)
        val tbDescription = findViewById<TextView>(R.id.textViewRateAppDescription)

        //Récupération de la dernière notation via requête HTTP:
        val lastScoreURL = "https://saufrasoft.fr/epsi/last_rate.txt"
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(lastScoreURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    tbDescription.text = getString(R.string.error_RateApp_GetLastRate)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                val value : String = data.toString()

                runOnUiThread {
                    rBar.rating = value.toFloat()
                }
            }

        })

        btnSubmit.setOnClickListener {
            val userScore = rBar.rating.toString()

            val submitURL = "https://saufrasoft.fr/epsi/submit_rate.php?&rate="
            val requestURL = "$submitURL$userScore"

            tbDescription.text = getString(R.string.info_RateApp_Submitting)
            //Envoi de la notation via une requête HTTP:
            val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
            val request = Request.Builder()
                .url(requestURL)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()

            okHttpClient.newCall(request).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        tbDescription.text = getString(R.string.error_RateApp_SubmitRate)
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body?.string()
                    runOnUiThread {
                        tbDescription.text = data
                    }
                }

            })

        }
    }

}