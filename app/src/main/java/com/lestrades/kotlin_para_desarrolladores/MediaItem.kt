package com.lestrades.kotlin_para_desarrolladores

import java.lang.reflect.Type

data class MediaItem (val id:Int, val title: String, val url:String, val type :Type){
    enum class Type {PHOTO,VIDEO}
}