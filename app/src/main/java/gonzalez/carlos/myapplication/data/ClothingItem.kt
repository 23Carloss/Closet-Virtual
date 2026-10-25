package gonzalez.carlos.myapplication.data

import androidx.compose.ui.graphics.Color

data class ClothingItem(
    val id: String,
    val title: String,
    val category: String,
    val brand: String,
    val size: String,
    val tags: List<String>,
    val dotColor: Color,
    val totalUses: Int,
    val avgUsesPerMonth: String
)