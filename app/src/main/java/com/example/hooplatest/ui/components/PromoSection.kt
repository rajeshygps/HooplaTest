package com.example.hooplatest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hooplatest.data.LayoutItem
import com.example.hooplatest.util.getDrawableId

@Composable
fun PromoSection(block: LayoutItem) {
    val resId = block.thumbnail?.let { getDrawableId(it) } ?: 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(200.dp),
        shape = androidx.compose.material3.MaterialTheme.shapes.medium
    ) {
        if (resId != 0) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = block.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
