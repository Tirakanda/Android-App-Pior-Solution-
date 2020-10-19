package com.example.myapplication

import com.example.myapplication.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("job_list.json")
    fun getUser() : Call<List<User>>
}