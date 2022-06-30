package com.lestrades.kotlin_para_desarrolladores

import com.lestrades.kotlin_para_desarrolladores.MediaItem.*

fun getItems():List<MediaItem> = listOf(
    MediaItem("Title 1", "https://placekitten.com/200/200?image=1", Type.PHOTO),
    MediaItem("Title 2", "https://placekitten.com/200/200?image=2", Type.VIDEO),
    MediaItem("Title 3", "https://placekitten.com/200/200?image=3", Type.PHOTO),
    MediaItem("Title 4", "https://placekitten.com/200/200?image=4", Type.PHOTO),
    MediaItem("Title 5", "https://placekitten.com/200/200?image=5", Type.VIDEO),
    MediaItem("Title 6", "https://placekitten.com/200/200?image=6", Type.PHOTO),
    MediaItem("Title 7", "https://placekitten.com/200/200?image=7", Type.PHOTO),
    MediaItem("Title 8", "https://placekitten.com/200/200?image=8", Type.PHOTO),
    MediaItem("Title 9", "https://placekitten.com/200/200?image=9", Type.VIDEO),
    MediaItem("Title 10", "https://placekitten.com/200/200?image=10", Type.PHOTO),
)