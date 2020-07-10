package com.example.learning_android_kotlin

import retrofit2.Response
import retrofit2.http.GET

interface AlbumInterface {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
}