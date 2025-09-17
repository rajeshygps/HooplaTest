package com.example.hooplatest.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hooplatest.data.CardItem
import com.example.hooplatest.data.LayoutItem
import com.example.hooplatest.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: DataRepository
) : AndroidViewModel(application) {

    private val _layoutItems = MutableStateFlow<List<LayoutItem>>(emptyList())
    val layoutItems: StateFlow<List<LayoutItem>> = _layoutItems

    private val _cardsItems = MutableStateFlow<Map<String, List<CardItem>>>(emptyMap())
    val cardsItems: StateFlow<Map<String, List<CardItem>>> = _cardsItems

    init {
        viewModelScope.launch {
            val layouts = repository.loadLayoutItems()
            _layoutItems.value = layouts

            val cardsMap = mutableMapOf<String, List<CardItem>>()
            layouts.filter { it.type == "CAROUSEL" }.forEach { block ->
                block.dataSourceUrl?.let { file ->
                    cardsMap[block.title ?: ""] = repository.loadCards(file)
                }
            }
            _cardsItems.value = cardsMap
        }
    }
}

