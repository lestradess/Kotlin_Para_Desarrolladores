package com.lestrades.kotlin_para_desarrolladores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.recycler)
        recycler.adapter = MediaAdapter(getItems())
    }
    private fun toast(message:String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}