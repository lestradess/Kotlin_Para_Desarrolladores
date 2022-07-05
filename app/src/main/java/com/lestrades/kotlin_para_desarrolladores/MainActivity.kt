package com.lestrades.kotlin_para_desarrolladores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Filter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.lestrades.kotlin_para_desarrolladores.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.function.ToDoubleBiFunction
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {

    private val adapter = MediaAdapter {
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to it.id )
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        updateItems()
    }

    private fun updateItems(filter: Int = R.id.fiter_all) {

        lifecycleScope.launch {
            binding.progress.visibility = View.VISIBLE
            adapter.items = withContext(Dispatchers.IO) { getFilterItems(filter) }
            binding.progress.visibility = View.GONE
        }
    }

    private fun getFilterItems(filter: Int): List<MediaItem> {
        return when (filter) {
            R.id.fiter_all -> MediaProvider.getItems()
            R.id.filter_videos-> MediaProvider.getItems().filter { it.type == MediaItem.Type.VIDEO }
            R.id.filter_photos-> MediaProvider.getItems().filter { it.type == MediaItem.Type.PHOTO }
            else -> emptyList()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        updateItems(item.itemId)
        return super.onOptionsItemSelected(item)
    }

}