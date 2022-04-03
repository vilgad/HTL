package com.example.monarch.dataClasses

data class PlaylistItems(
    val pageInfo: PageInfo,
    val items: List<PlaylistItem>,
    val nextPageToken: String
) {
    data class PlaylistItem(val snippet: PlaylistItemSnippet) {
        data class PlaylistItemSnippet(
            private val title: String,
            val thumbnails: Thumbnails,
            private val channelTitle: String,
            private val position: String,
            val resourceId: PlaylistResource
        ) {
            fun getVideoTitle(): String {
                return title
            }

            fun getChannelTitle(): String {
                return channelTitle
            }

            fun getVideoNumber(): Int {
                return position.toInt() + 1
            }

            data class PlaylistResource(private val videoId: String) {
                fun getVideoId(): String {
                    return videoId
                }
            }
        }
    }
}
