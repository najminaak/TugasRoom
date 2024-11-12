package com.example.tugasretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasretrofit.databinding.ActivityMainBinding
import com.example.tugasretrofit.model.Pesantren
import com.example.tugasretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val responsePesantren = client.getPesantren()

        responsePesantren.enqueue(object : Callback<List<Pesantren>> {
            override fun onResponse(call: Call<List<Pesantren>>, response: Response<List<Pesantren>>) {
                if (response.isSuccessful) {
                    val pesantrenList = response.body()
                    if (pesantrenList != null && pesantrenList.isNotEmpty()) {
                        val listAdapter = PesantrenAdapter(pesantrenList)
                        binding.rvPesantren.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.rvPesantren.adapter = listAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Pesantren>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi Error", Toast.LENGTH_SHORT).show()
            }
        })

    }
}