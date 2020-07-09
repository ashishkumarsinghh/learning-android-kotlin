package com.example.learning_android_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCurrentQuiz()
    }
    private fun getCurrentQuiz(){
        val retrofit = Retrofit.Builder().baseUrl(Constants.API_BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(QuizAPI::class.java)
        val call = service.getQuestions(10, "18", "easy")
        call.enqueue(object : Callback<QuizResponse> {
            override fun onFailure(call: Call<QuizResponse>, t: Throwable) {
                Log.d("retro", t.toString())
            }
            override fun onResponse(call: Call<QuizResponse>, response: Response<QuizResponse>) {
                val body = response.body()!!
                Log.d("retro", ""+body.results)
            }
        }
        )
    }
}