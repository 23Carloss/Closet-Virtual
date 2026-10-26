package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import gonzalez.carlos.myapplication.data.ClothingItem
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun DetallePrendaScreen(
    modifier: Modifier = Modifier,
    item: ClothingItem = sampleClothingItems.first(),
    onBackClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    selectedNavTab: Int = 0,
    onNavTabSelected: (Int) -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize().background(BackgroundCream)) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = DarkBrown,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Detalles de Prenda",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = DarkBrown,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.size(36.dp))
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF3E2A1E)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(
                            text = item.category.uppercase(),
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color(0xFFC87A4B)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(210.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(Color(0xFF2B1D15)),
                            contentAlignment = Alignment.Center
                        ) {
                            // Template para imagen de la prenda
                            Icon(
                                imageVector = Icons.Outlined.Checkroom,
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.15f),
                                modifier = Modifier.size(80.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.title,
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = Color.White
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "${item.brand} • Talla ${item.size}",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 13.sp,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(item.dotColor)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Historial de Uso",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = DarkBrown
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Surface(
                        modifier = Modifier.weight(1f).height(115.dp),
                        shape = RoundedCornerShape(14.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, LightBrownBorder)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(12.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total de Usos:",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 13.sp,
                                color = DarkBrown
                            )

                            Text(
                                text = "${item.totalUses}",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 38.sp,
                                color = Color(0xFF3E2A1E),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            Text(
                                text = "veces",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = DarkBrown,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    Surface(
                        modifier = Modifier.weight(1f).height(115.dp),
                        shape = RoundedCornerShape(14.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, LightBrownBorder)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(12.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Promedio:",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 13.sp,
                                color = DarkBrown
                            )

                            Text(
                                text = item.avgUsesPerMonth,
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 38.sp,
                                color = Color(0xFF3E2A1E),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            Text(
                                text = "veces por mes",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = DarkBrown,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth().height(48.dp).clickable { onEditClick() },
                    shape = RoundedCornerShape(12.dp),
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Editar Prenda",
                            tint = Color(0xFF3E2A1E),
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Editar Prenda",
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color(0xFF3E2A1E)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth().height(48.dp).clickable { onDeleteClick() },
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFFDF0F0),
                    border = BorderStroke(1.dp, Color(0xFFF5C6C6))
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Eliminar Prenda",
                            tint = Color(0xFFC0392B),
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Eliminar Prenda",
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color(0xFFC0392B)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            AppBottomNavigation(
                selectedTab = selectedNavTab,
                onTabSelected = onNavTabSelected
            )
        }
    }
}

@Composable
fun AppBottomNavigation(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = BackgroundCream,
        border = BorderStroke(0.5.dp, LightBrownBorder.copy(alpha = 0.3f))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val items = listOf(
                Triple("Armario", Icons.Outlined.Checkroom, Icons.Filled.Checkroom),
                Triple("Outfits", Icons.Outlined.AutoAwesome, Icons.Filled.AutoAwesome),
                Triple("Inicio", Icons.Outlined.Home, Icons.Filled.Home),
                Triple("Calendario", Icons.Outlined.CalendarToday, Icons.Filled.CalendarToday),
                Triple("Ajustes", Icons.Outlined.Settings, Icons.Filled.Settings)
            )

            items.forEachIndexed { index, (label, unselectedIcon, selectedIcon) ->
                val isSelected = selectedTab == index
                val itemColor = if (isSelected) DarkBrown else DarkBrown.copy(alpha = 0.5f)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { onTabSelected(index) }
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = if (isSelected) selectedIcon else unselectedIcon,
                        contentDescription = label,
                        tint = itemColor,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = label,
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        fontSize = 11.sp,
                        color = itemColor
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun DetallePrendaScreenPreview() {
    MyApplicationTheme {
        DetallePrendaScreen()
    }
}