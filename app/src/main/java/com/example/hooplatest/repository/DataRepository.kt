package com.example.hooplatest.repository

import android.content.Context
import com.example.hooplatest.data.CardItem
import com.example.hooplatest.data.LayoutItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DataRepository(private val context: Context) {

    private fun loadJsonFromAssets(fileName: String): String {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            ""
        }
    }

    fun loadLayoutItems(): List<LayoutItem> {
        val json = loadJsonFromAssets("layout.json")
        val type = object : TypeToken<List<LayoutItem>>() {}.type
        return Gson().fromJson(json, type)
    }

    fun loadCards(fileName: String): List<CardItem> {
        val json = loadJsonFromAssets(fileName)
        val type = object : TypeToken<List<CardItem>>() {}.type
        return Gson().fromJson(json, type)
    }
}
