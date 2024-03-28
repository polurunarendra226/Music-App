package com.example.mymusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.MyMusicAdapter

import com.example.mymusicapp.APi.Api_call
import com.example.mymusicapp.Models.User
import com.example.mymusicapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


      var retrofit = Retrofit.Builder()
          .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(Api_call::class.java)
        val retrofit_data = retrofit.getData("eminem")

      retrofit_data.enqueue(object : Callback<User?> {
          override fun onResponse(call: Call<User?>, response: Response<User?>) {
              var datalist = response.body()?.data
              binding.rvMusic.adapter= datalist?.let { MyMusicAdapter(this@MainActivity, it) }
              binding.rvMusic.layoutManager=LinearLayoutManager(this@MainActivity)
          }

          override fun onFailure(call: Call<User?>, t: Throwable) {
              t.message?.let { Log.d("Data", it) }
          }
      })
    }
}