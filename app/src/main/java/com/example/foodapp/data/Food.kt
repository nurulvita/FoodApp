package com.example.foodapp.data

data class Food(
    val id: String,
    val name: String,
    val description: String,
    val imageRes: Int,
    val category: FoodCategory,
    val price: Int
)
