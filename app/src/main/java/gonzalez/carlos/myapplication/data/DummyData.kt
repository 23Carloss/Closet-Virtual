package gonzalez.carlos.myapplication.data

import androidx.compose.ui.graphics.Color

val sampleClothingItems = listOf(
    ClothingItem(
        id = "1",
        title = "Blazer Oversize Camel",
        category = "CAMISAS",
        brand = "Zara",
        size = "M",
        tags = listOf("Formal", "Otoño"),
        dotColor = Color(0xFFE05342),
        totalUses = 10,
        avgUsesPerMonth = "3.5"
    ),
    ClothingItem(
        id = "2",
        title = "T-Shirt Algodón Beige",
        category = "PLAYERAS",
        brand = "Mango",
        size = "M",
        tags = listOf("Básico", "Casual"),
        dotColor = Color(0xFFC87A4B),
        totalUses = 8,
        avgUsesPerMonth = "2.8"
    ),
    ClothingItem(
        id = "3",
        title = "Jeans Slim Azul",
        category = "PANTALONES",
        brand = "Levi's",
        size = "32",
        tags = listOf("Casual", "Verano"),
        dotColor = Color(0xFFC9936B),
        totalUses = 15,
        avgUsesPerMonth = "4.2"
    ),
    ClothingItem(
        id = "4",
        title = "T-Shirt Gráfica Negra",
        category = "PLAYERAS",
        brand = "H&M",
        size = "L",
        tags = listOf("Gráfico", "Casual"),
        dotColor = Color(0xFFC87A4B),
        totalUses = 12,
        avgUsesPerMonth = "3.0"
    )
)