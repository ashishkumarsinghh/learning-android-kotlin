package com.example.learning_android_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retService = RetrofitInstance.getRetrofitInstance().create(AlbumInterface::class.java)
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getAlbums()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumlist = it.body()?.listIterator()
            if(albumlist != null){
                while(albumlist.hasNext()){
                    val albumItem = albumlist.next()
                    Log.d("retrofit", albumItem.title)

                }
            }
        })
    }

}