package com.lestrades.kotlin_para_desarrolladores

import android.content.Context
import android.widget.Toast

fun Context.toast(message:String,length : Int = Toast.LENGTH_LONG){
    Toast.makeText(this,message, length).show()
}
fun MediaAdapter.ViewHolder.toast(texto: String){
    itemView.context.toast(texto)
}