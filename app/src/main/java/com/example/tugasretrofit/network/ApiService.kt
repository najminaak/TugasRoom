package com.example.tugasretrofit.network

import com.example.tugasretrofit.model.Pesantren
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pesantren/3206.json")
    fun getPesantren(): Call<List<Pesantren>>

}