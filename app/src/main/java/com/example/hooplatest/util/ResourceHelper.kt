package com.example.hooplatest.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun getDrawableId(name: String?): Int {
    if (name == null) return 0
    val context = LocalContext.current
    return context.resources.getIdentifier(
        name.substringBeforeLast("."),
        "drawable",
        context.packageName
    )
}
