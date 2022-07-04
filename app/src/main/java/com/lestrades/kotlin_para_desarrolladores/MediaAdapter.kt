package com.lestrades.kotlin_para_desarrolladores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lestrades.kotlin_para_desarrolladores.databinding.ViewMediaItemBinding
import kotlin.properties.Delegates

class MediaAdapter(
    items: List<MediaItem> = emptyList(),
    private val listener:(MediaItem)-> Unit) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    var items: List<MediaItem> by Delegates.observable(items){ property, oldValue, newValue ->
        notifyDataSetChanged()
    }

    //Se llama para crear una nueva tarjeta. Infla la vista.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater
//            .from(parent.context)
//            .inflate(R.layout.view_media_item,parent,false)
//        val view = parent.inflate(R.layout.view_media_item)
        val binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }

    //Asignamos los valores a esa tarjeta
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    //Devuelve el número de items que tiene la lista.
    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewMediaItemBinding.bind(view)


        fun bind(mediaItem: MediaItem) {
            with(binding) {
                mediaTitle.text = mediaItem.title
                mediaThumb.loadUrl(mediaItem.url)
                mediaVideoIndicator.visibility = when (mediaItem.type) {
                    MediaItem.Type.PHOTO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }
    }
}