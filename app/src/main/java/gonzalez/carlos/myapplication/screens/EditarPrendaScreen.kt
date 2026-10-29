package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.data.ClothingItem
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarPrendaScreen(
    modifier: Modifier = Modifier,
    item: ClothingItem = sampleClothingItems.first(),
    onBackClick: () -> Unit = {},
    onSaveSuccess: () -> Unit = {},
    selectedNavTab: Int = 0,
    onNavTabSelected: (Int) -> Unit = {}
) {
    var title by remember { mutableStateOf(item.title) }
    var category by remember { mutableStateOf(item.category) }
    var brand by remember { mutableStateOf(item.brand) }
    var size by remember { mutableStateOf(item.size) }
    var tagsInput by remember { mutableStateOf(item.tags.joinToString(", ")) }

    var titleError by remember { mutableStateOf<String?>(null) }
    var categoryError by remember { mutableStateOf<String?>(null) }

    var expandedCategoryMenu by remember { mutableStateOf(false) }
    val categoryOptions = listOf("Camisas", "Playeras", "Pantalones", "Zapatos", "Accesorios")

    fun validateAndSave() {
        var isValid = true

        if (title.isBlank()) {
            titleError = "El nombre de la prenda es requerido"
            isValid = false
        } else {
            titleError = null
        }

        if (category.isBlank()) {
            categoryError = "Selecciona una categoría"
            isValid = false
        } else {
            categoryError = null
        }

        if (isValid) {
            onSaveSuccess()
        }
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
                        text = "Editar Prenda",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = DarkBrown,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Modifica los detalles de tu prenda",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MediumBrown,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.size(36.dp))
            }

            // Formulario
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                // Foto de la prenda
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF3E2A1E)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Checkroom,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.3f),
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            modifier = Modifier.clickable { },
                            shape = RoundedCornerShape(20.dp),
                            color = MediumBrown
                        ) {
                            Text(
                                text = "Cambiar Foto",
                                fontFamily = PlusJakartaSansFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Nombre de la prenda
                CustomTextField(
                    label = "Nombre de la prenda",
                    value = title,
                    onValueChange = {
                        title = it
                        if (titleError != null) titleError = null
                    },
                    errorMessage = titleError
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Categoría
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Categoría",
                        fontFamily = PlusJakartaSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = DarkBrown
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    ExposedDropdownMenuBox(
                        expanded = expandedCategoryMenu,
                        onExpandedChange = { expandedCategoryMenu = !expandedCategoryMenu },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true),
                            shape = RoundedCornerShape(12.dp),
                            color = FieldBackground,
                            border = BorderStroke(1.5.dp, if (!categoryError.isNullOrEmpty()) Color(0xFFD32F2F) else LightBrownBorder)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (category.isEmpty()) "Seleccionar categoría" else category,
                                    fontFamily = PlusJakartaSansFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = if (category.isEmpty()) TextPlaceholder else DarkBrown
                                )

                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCategoryMenu)
                            }
                        }

                        ExposedDropdownMenu(
                            expanded = expandedCategoryMenu,
                            onDismissRequest = { expandedCategoryMenu = false },
                            modifier = Modifier.background(BackgroundCream)
                        ) {
                            categoryOptions.forEach { option ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = option,
                                            fontFamily = PlusJakartaSansFontFamily,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 14.sp,
                                            color = DarkBrown
                                        )
                                    },
                                    onClick = {
                                        category = option
                                        expandedCategoryMenu = false
                                        if (categoryError != null) categoryError = null
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                )
                            }
                        }
                    }

                    if (!categoryError.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = categoryError!!,
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = Color(0xFFD32F2F)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Marca
                CustomTextField(
                    label = "Marca",
                    value = brand,
                    onValueChange = { brand = it }
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Talla
                CustomTextField(
                    label = "Talla",
                    value = size,
                    onValueChange = { size = it }
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Etiquetas
                CustomTextField(
                    label = "Etiquetas (separadas por coma)",
                    value = tagsInput,
                    onValueChange = { tagsInput = it }
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Botones Guardar y Cancelar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { validateAndSave() },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = DarkBrown,
                            contentColor = BackgroundCream
                        ),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                    ) {
                        Text(
                            text = "Guardar Cambios",
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = BackgroundCream
                        )
                    }

                    OutlinedButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.5.dp, MediumBrown),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MediumBrown
                        )
                    ) {
                        Text(
                            text = "Cancelar",
                            fontFamily = PlusJakartaSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = MediumBrown
                        )
                    }
                }

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
fun EditarPrendaScreenPreview() {
    MyApplicationTheme {
        EditarPrendaScreen()
    }
}