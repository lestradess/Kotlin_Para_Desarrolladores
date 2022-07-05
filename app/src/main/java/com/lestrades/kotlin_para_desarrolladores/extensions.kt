package com.lestrades.kotlin_para_desarrolladores

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
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
fun ImageView.loadUrl(url:String){
    Glide.with(this).load(url).into(this)
}
inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String,Any?>){
    val intent = Intent(this,T::class.java).apply{
        putExtras(bundleOf(*pairs))
    }
    startActivity(intent)
}