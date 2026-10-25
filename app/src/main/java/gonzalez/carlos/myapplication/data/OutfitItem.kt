package gonzalez.carlos.myapplication.data

import androidx.compose.ui.graphics.Color

data class OutfitItem(
    val id: String,
    val title: String,
    val category: String,
    val itemsCountText: String,
    val tags: List<String>,
    val dotColor: Color = Color(0xFFC87A4B),
    val isFavorite: Boolean = false,
    val isMine: Boolean = true,
    val author: String = "Luis Pérez"
)