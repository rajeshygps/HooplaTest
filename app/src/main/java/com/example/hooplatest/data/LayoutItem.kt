package com.example.hooplatest.data

data class LayoutItem (
    val type: String,
    val title: String? = null,
    val thumbnail: String? = null,
    val dataSourceUrl: String? = null,
)

data class CardItem(
    val thumbnail: String
)