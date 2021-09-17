package com.rawan.recyclerviewcategories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rawan.recyclerviewcategories.R
import com.rawan.recyclerviewcategories.databinding.ActivityMainBinding
import com.rawan.recyclerviewcategories.model.Category
import com.rawan.recyclerviewcategories.ui.adapter.OnCategoryClick
import com.rawan.recyclerviewcategories.ui.adapter.RecyclerAdapter


class MainActivity : AppCompatActivity(), OnCategoryClick {

    // lateinit  var adapter:RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>
    lateinit var layoutManager: RecyclerView.LayoutManager
   // lateinit var recyclerView: RecyclerView
    //var data = ArrayList<Category>()
    //var name: String? = null
lateinit var binding: ActivityMainBinding

    val recyclerAdapter: RecyclerAdapter by lazy {
        RecyclerAdapter()
    }

    var categoryList: ArrayList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // recyclerView = findViewById(R.id.recyclerView)
        /* recyclerView.layoutManager = GridLayoutManager(this, 2)
         recyclerView = RecyclerView(this)*/



        for (i in 0..3) {
            when (i % 4) {
                0 -> categoryList.add(Category("orthodontics ", R.drawable.img1))
                1 -> categoryList.add(Category("Endodontics", R.drawable.img2))
                2 -> categoryList.add(Category("Dental Public Health", R.drawable.img3))
                else -> categoryList.add(Category("Oral and Maxillofacial Surgery.", R.drawable.img))
            }
            recyclerAdapter.setList(categoryList)

        }

        layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager


        // adapter=RecyclerAdapter()
        //recyclerView.adapter=adapter

        binding.recyclerView.adapter = recyclerAdapter


        recyclerAdapter.onCategoryClick = this

    }

    override fun onItemCategoryClick(category: Category) {
        Toast.makeText(this, "the category name is :${category.name}", Toast.LENGTH_SHORT).show()
    }

}