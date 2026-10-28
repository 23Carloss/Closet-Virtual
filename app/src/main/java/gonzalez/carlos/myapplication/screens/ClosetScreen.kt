package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.R
import gonzalez.carlos.myapplication.data.ClothingItem
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.data.sampleUserProfile
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun ClosetScreen(
    modifier: Modifier = Modifier,
    onItemClick: (ClothingItem) -> Unit = {},
    onAddClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    selectedNavTab: Int = 0,
    onNavTabSelected: (Int) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Camisas", "Pantalones", "Zapatos")

    val displayedItems = sampleClothingItems.filter { item ->
        val matchesCategory = if (selectedCategory == "Todos") true else item.category.equals(selectedCategory, ignoreCase = true)
        val matchesSearch = searchQuery.isEmpty() || item.title.contains(searchQuery, ignoreCase = true) || item.brand.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundCream)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF8B0000)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profilepfp),
                        contentDescription = "Avatar de Usuario",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize().clickable { onProfileClick() }
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "CloudCloset",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = DarkBrown
                    )
                    Text(
                        text = "Bienvenido, ${sampleUserProfile.name}!",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = DarkBrown
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .height(46.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Buscar",
                            tint = IconColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Buscar por prenda, marca...",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontSize = 14.sp,
                                    color = TextPlaceholder
                                )
                            }
                            BasicTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = DarkBrown
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                categories.forEach { cat ->
                    val isSelected = selectedCategory == cat
                    Surface(
                        modifier = Modifier
                            .height(34.dp)
                            .clickable { selectedCategory = cat },
                        shape = RoundedCornerShape(18.dp),
                        color = if (isSelected) MediumBrown else FieldBackground,
                        border = if (isSelected) null else BorderStroke(1.5.dp, LightBrownBorder)
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = cat,
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                fontSize = 13.sp,
                                color = if (isSelected) Color.White else DarkBrown
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Mostrando ${displayedItems.size} prendas",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = DarkBrown,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(displayedItems) { item ->
                        ClothingCard(
                            item = item,
                            onClick = { onItemClick(item) }
                        )
                    }
                }

                FloatingActionButton(
                    onClick = onAddClick,
                    shape = CircleShape,
                    containerColor = MediumBrown,
                    contentColor = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 20.dp, bottom = 16.dp)
                        .size(52.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar Prenda",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            AppBottomNavigation(
                selectedTab = selectedNavTab,
                onTabSelected = onNavTabSelected
            )
        }
    }
}

@Composable
fun ClothingCard(
    item: ClothingItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3E2A1E)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF2B1D15)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Checkroom,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.15f),
                    modifier = Modifier.size(48.dp)
                )
            }

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.category.uppercase(),
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color(0xFFC87A4B)
                    )

                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(item.dotColor)
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.title,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White,
                    maxLines = 1
                )

                Text(
                    text = item.brand,
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    item.tags.forEach { tag ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFF503828)
                        ) {
                            Text(
                                text = tag,
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp,
                                color = Color.White.copy(alpha = 0.9f),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
fun ClosetScreenPreview() {
    MyApplicationTheme {
        ClosetScreen()
    }
}