package com.rawan.recyclerviewcategories.ui.adapter

import com.rawan.recyclerviewcategories.model.Category

interface OnCategoryClick {
    fun onItemCategoryClick(categories: Category)
}