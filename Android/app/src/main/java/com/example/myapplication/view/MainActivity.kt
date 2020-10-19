package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ApiService
import com.example.myapplication.R
import com.example.myapplication.model.User
import com.example.myapplication.viewmodel.RecycleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://dev.priorsolution.co.th/test/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                d("Success", "onResponse: ${response.body()!!}")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("Failed", "onFailure")
            }
        })
    }

    private fun showData(user: List<User>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecycleAdapter(user)
    }
}


