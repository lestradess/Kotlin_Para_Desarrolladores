package com.lestrades.kotlin_para_desarrolladores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun Context.toast(message:String,length : Int = Toast.LENGTH_LONG){
    Toast.makeText(this,message, length).show()
}
fun MediaAdapter.ViewHolder.toast(texto: String){
    itemView.context.toast(texto)
}
fun ViewGroup.inflate(@LayoutRes int: Int): View {
    return LayoutInflater
        .from(this.context)
        .inflate(int,this,false)
}
