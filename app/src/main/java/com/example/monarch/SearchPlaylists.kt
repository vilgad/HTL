package com.example.monarch

data class Thumbnails(val default: Default)
data class Default(val url: String)
data class SearchPlaylists(
    val pageInfo: PageInfo,
    val items: List<SearchItems>,
    val nextPageToken: String
)

data class SearchItems(val id: SearchID, val snippet: SearchSnippet)

data class SearchID(val playlistId: String)

data class SearchSnippet(val thumbnails: Thumbnails, val title: String, val channelTitle: String)