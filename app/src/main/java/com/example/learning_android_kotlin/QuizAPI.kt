package com.example.learning_android_kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizAPI {
    @GET("api.php?")
    fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: String,
        @Query("difficulty") difficulty: String
    ): Call<QuizResponse>
}