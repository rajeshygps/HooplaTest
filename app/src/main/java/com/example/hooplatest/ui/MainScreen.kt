package com.example.hooplatest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hooplatest.ui.components.CarouselSection
import com.example.hooplatest.ui.components.PromoSection
import com.example.hooplatest.vm.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val layoutItems by viewModel.layoutItems.collectAsStateWithLifecycle()
    val cards by viewModel.cardsItems.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // ✅ enable vertical scrolling
    ) {
        layoutItems.forEach { item ->
            when (item.type) {
                "PROMO" -> PromoSection(item)
                "CAROUSEL" -> {
                    val cardList = cards[item.title] ?: emptyList()
                    CarouselSection(item, cardList)
                }
            }
        }
    }
}
