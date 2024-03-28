package com.example.domain.entities

data class TagItem(
    val category: String,
    val internalName: String,
    val localizedCategoryName: String,
    val localizedTagName: String,
    var color : String?
)