package com.example.monarch.apiClasses

import com.example.monarch.dataClasses.PlaylistItems
import com.example.monarch.utils.API_KEY
import com.example.monarch.utils.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CourseInterface {
    @GET("search?part=snippet&key=$API_KEY&type=playlist")
    fun getPlaylists(
        @Query("q") q: String,
        @Query("pageToken") pageToken: String
    ): Call<PlaylistItems>
}

object CourseService{
    val courseInstance: CourseInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        courseInstance = retrofit.create(CourseInterface::class.java)
    }
}