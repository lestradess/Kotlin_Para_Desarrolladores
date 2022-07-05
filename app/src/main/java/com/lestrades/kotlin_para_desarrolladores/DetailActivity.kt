package com.lestrades.kotlin_para_desarrolladores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.lestrades.kotlin_para_desarrolladores.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "DetailActivity:id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemId = intent.getIntExtra(EXTRA_ID, -1)

        lifecycleScope.launch{
            val items = withContext(Dispatchers.IO){
                MediaProvider.getItems()
            }
            val item = items.firstOrNull{it.id == itemId}
            if (item != null){

            }
            item?.let{
                // con el ? si el supportActionBar es null no se ejecutará el lado
                //derecho del ?
                supportActionBar?.title = item.title
                binding.detailThumb.loadUrl(item.url)
                binding.detailVideoIndicator.visibility = when(item.type){
                    MediaItem.Type.PHOTO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }

    }
}