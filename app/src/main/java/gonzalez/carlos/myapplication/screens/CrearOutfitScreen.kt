package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun CrearOutfitScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onSaveSuccess: () -> Unit = {},
    onSelectFromClosetClick: () -> Unit = {},
    selectedNavTab: Int = 1,
    onNavTabSelected: (Int) -> Unit = {}
) {
    var outfitName by remember { mutableStateOf("") }
    var tagsInput by remember { mutableStateOf("") }
    var isPrivate by remember { mutableStateOf(true) } // true: Privado, false: Público
    var saveToFavorites by remember { mutableStateOf(false) }

    var selectedItemIds by remember { mutableStateOf(setOf<String>()) }
    val availableItems = sampleClothingItems

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
                    .padding(horizontal = 16.dp, vertical = 12.dp),
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

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Crear outfit",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = DarkBrown,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Combina prendas de tu clóset",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MediumBrown,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.size(36.dp))
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Nombre del outfit",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = DarkBrown
                )
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 14.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (outfitName.isEmpty()) {
                            Text(
                                text = "Ej. Look de otoño",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontSize = 14.sp,
                                color = TextPlaceholder
                            )
                        }
                        BasicTextField(
                            value = outfitName,
                            onValueChange = { outfitName = it },
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

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Prendas seleccionadas",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = DarkBrown
                    )
                    Text(
                        text = "${selectedItemIds.size} seleccionadas",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = MediumBrown
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    availableItems.take(3).forEach { item ->
                        val isSelected = selectedItemIds.contains(item.id)
                        Surface(modifier = Modifier.fillMaxWidth()
                                .clickable {
                                    selectedItemIds = if (isSelected) {
                                        selectedItemIds - item.id
                                    } else {
                                        selectedItemIds + item.id
                                    }
                                },
                            shape = RoundedCornerShape(14.dp),
                            color = FieldBackground,
                            border = BorderStroke(1.5.dp, if (isSelected) DarkBrown else LightBrownBorder)
                        ) {
                            Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFFEDE5DA)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Checkroom,
                                        contentDescription = null,
                                        tint = DarkBrown.copy(alpha = 0.4f),
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = item.title,
                                        fontFamily = PlusJakartaSansFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = DarkBrown
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "${item.category.lowercase().replaceFirstChar { it.uppercase() }} · ${item.brand}",
                                        fontFamily = PlusJakartaSansFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 12.sp,
                                        color = MediumBrown
                                    )
                                }

                                Surface(
                                    modifier = Modifier.size(22.dp),
                                    shape = CircleShape,
                                    color = if (isSelected) DarkBrown else Color.Transparent,
                                    border = BorderStroke(1.5.dp, if (isSelected) DarkBrown else LightBrownBorder)
                                ) {
                                    if (isSelected) {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Box(modifier = Modifier.size(8.dp).clip(CircleShape)
                                                    .background(BackgroundCream)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .clickable { onSelectFromClosetClick() },
                        shape = RoundedCornerShape(12.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, LightBrownBorder)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+ Seleccionar prendas del clóset",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = DarkBrown
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Etiquetas",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = DarkBrown
                )
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, LightBrownBorder)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 14.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (tagsInput.isEmpty()) {
                            Text(
                                text = "Añadir etiquetas (casual, otoño...)",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontSize = 14.sp,
                                color = TextPlaceholder
                            )
                        }
                        BasicTextField(
                            value = tagsInput,
                            onValueChange = { tagsInput = it },
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

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Privacidad",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = DarkBrown
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { isPrivate = true },
                        shape = RoundedCornerShape(12.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, if (isPrivate) DarkBrown else LightBrownBorder)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(18.dp)
                                    .clip(CircleShape)
                                    .background(if (isPrivate) DarkBrown else Color.Transparent)
                                    .border(1.5.dp, if (isPrivate) DarkBrown else LightBrownBorder, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                if (isPrivate) {
                                    Box(
                                        modifier = Modifier
                                            .size(6.dp)
                                            .clip(CircleShape)
                                            .background(BackgroundCream)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Text(
                                    text = "Privado",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = DarkBrown
                                )
                                Text(
                                    text = "Solo tú lo ves",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp,
                                    color = MediumBrown
                                )
                            }
                        }
                    }

                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { isPrivate = false },
                        shape = RoundedCornerShape(12.dp),
                        color = FieldBackground,
                        border = BorderStroke(1.5.dp, if (!isPrivate) DarkBrown else LightBrownBorder)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(18.dp)
                                    .clip(CircleShape)
                                    .background(if (!isPrivate) DarkBrown else Color.Transparent)
                                    .border(1.5.dp, if (!isPrivate) DarkBrown else LightBrownBorder, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                if (!isPrivate) {
                                    Box(
                                        modifier = Modifier
                                            .size(6.dp)
                                            .clip(CircleShape)
                                            .background(BackgroundCream)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                Text(
                                    text = "Público",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = DarkBrown
                                )
                                Text(
                                    text = "Compartible",
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp,
                                    color = MediumBrown
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp)
                        .clickable { saveToFavorites = !saveToFavorites },
                    shape = RoundedCornerShape(12.dp),
                    color = FieldBackground,
                    border = BorderStroke(1.5.dp, if (saveToFavorites) DarkBrown else LightBrownBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if (saveToFavorites) Icons.Default.Star else Icons.Outlined.StarOutline,
                            contentDescription = null,
                            tint = if (saveToFavorites) Color(0xFFF1C40F) else DarkBrown,
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Guardar en favoritos",
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = DarkBrown
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onSaveSuccess,
                    modifier = Modifier.fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBrown,
                        contentColor = BackgroundCream
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text(
                        text = "Guardar outfit",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = BackgroundCream
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Podrás consultarlo y editarlo después.",
                    fontFamily = PlusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = MediumBrown,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            AppBottomNavigation(
                selectedTab = selectedNavTab,
                onTabSelected = onNavTabSelected
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun CrearOutfitScreenPreview() {
    MyApplicationTheme {
        CrearOutfitScreen()
    }
}