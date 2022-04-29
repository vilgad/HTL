package com.example.monarch.apiClasses

import com.example.monarch.dataClasses.PlaylistItems
import com.example.monarch.dataClasses.SearchPlaylists
import com.example.monarch.utils.API_KEY
import com.example.monarch.utils.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistItemInterface {
    @GET("playlistItems?part=snippet&key=$API_KEY")
    fun getPlaylists(
        @Query("playlistId") playlistId: String,
        @Query("pageToken") pageToken: String
    ): Call<PlaylistItems>
}

object PlaylistItemService{
    val playlistItemInstance: PlaylistItemInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        playlistItemInstance = retrofit.create(PlaylistItemInterface::class.java)
    }
}