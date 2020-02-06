package com.example.cardinfofinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cardinfofinder.model.*
import com.example.cardinfofinder.network.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            if (edit_search.text.toString().isNotEmpty()) {
                loadData(edit_search.text.toString())
            }
        }

    }

    private val ApiServe by lazy {
        ApiInterface.create()
    }

    private fun loadData(searchString: String) {
        ApiServe.getCountry("https://lookup.binlist.net/${searchString}").enqueue(object : Callback<Country> {
            override fun onFailure(call: Call<Country>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Error getting country" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Country>, response: Response<Country>) {

                val result = response.body()
                country.text = "${result!!.name}, ${result!!.emoji}"

            }


            /*  override fun onFailure(call: Call<Scheme>, t: Throwable) {
                  Toast.makeText(this@MainActivity , "Failed" , Toast.LENGTH_LONG).show()
              }

              override fun onResponse(call: Call<Scheme>, response: Response<Scheme>) {
                  val sub = response.body()
                  txt_search_scheme.text = "${sub!!.scheme}"
                  Toast.makeText(this@MainActivity , " response ${sub!!.scheme}" , Toast.LENGTH_LONG).show()

              }*/

        })



        ApiServe.getBrand("https://lookup.binlist.net/${searchString}").enqueue(object : Callback<Brand> {
            override fun onFailure(call: Call<Brand>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Error getting card brand" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Brand>, response: Response<Brand>) {
                val sub = response.body()
                brand.text = "${sub!!.brand}"
                Toast.makeText(this@MainActivity , " brand ${sub!!.brand}" , Toast.LENGTH_LONG).show()

            }

        })



        ApiServe.getType("https://lookup.binlist.net/${searchString}").enqueue(object : Callback<Type> {
            override fun onFailure(call: Call<Type>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Error getting card type" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Type>, response: Response<Type>) {

                val result = response.body()
                type.text = "${result!!.type}"
            }


            /*override fun onFailure(call: Call<Number>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Failed" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Number>, response: Response<Number>) {
                val sub = response.body()
                txt_search_number.text = "${sub!!.length}"
                txt_search_luhn.text = "${sub!!.luhn}"
                Toast.makeText(this@MainActivity , " brand ${sub!!.length}" , Toast.LENGTH_LONG).show()

            }*/

        })

        ApiServe.getBank("https://lookup.binlist.net/${searchString}").enqueue(object: Callback<Bank>{
            override fun onFailure(call: Call<Bank>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Error getting bank" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Bank>, response: Response<Bank>) {
                val result = response.body()
                bank.text = "${result!!.name}"
            }

        })



    }
}
