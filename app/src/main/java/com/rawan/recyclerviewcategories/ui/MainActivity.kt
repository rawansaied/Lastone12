package com.rawan.recyclerviewcategories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rawan.recyclerviewcategories.R
import com.rawan.recyclerviewcategories.model.Category
import com.rawan.recyclerviewcategories.ui.adapter.OnCategoryClick
import com.rawan.recyclerviewcategories.ui.adapter.RecyclerAdapter


class MainActivity : AppCompatActivity(),OnCategoryClick {

    // lateinit  var adapter:RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>
    //lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var recyclerView: RecyclerView
    //var name: String? = null


    val recyclerAdapter: RecyclerAdapter by lazy {
        RecyclerAdapter()
    }

    var categoryList: ArrayList<Category> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= GridLayoutManager(this,2)

        //layoutManager= GridLayoutManager(this,2)
        // recyclerView.layoutManager=layoutManager


        // adapter=RecyclerAdapter()
        //recyclerView.adapter=adapter

        recyclerView.adapter=RecyclerAdapter()


        recyclerAdapter.onCategoryClick=this

    }

    override fun onItemCategoryClick(category: Category) {
        Toast.makeText(this, "the category name is :${category.name}", Toast.LENGTH_SHORT).show()
    }

}