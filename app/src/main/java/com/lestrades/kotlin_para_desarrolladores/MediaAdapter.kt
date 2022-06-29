package com.lestrades.kotlin_para_desarrolladores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MediaAdapter(private val items : List<MediaItem>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>(){

    //Se llama para crear una nueva tarjeta. Infla la vista.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_media_item,parent,false)
        return ViewHolder(view)
    }
    //Asignamos los valores a esa tarjeta
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= items[position]
        holder.bind(item)
    }
    //Devuelve el número de items que tiene la lista.
    override fun getItemCount(): Int = items.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val title :TextView = view.findViewById(R.id.mediaTitle)
        private val thumb : ImageView = view.findViewById(R.id.mediaThumb)

        fun bind(mediaItem: MediaItem){
            title.text = mediaItem.title
            Glide.with(thumb).load(mediaItem.url).into(thumb)

            itemView.setOnClickListener {
                toast(mediaItem.title)
            }
        }
    }
}