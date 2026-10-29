package gonzalez.carlos.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gonzalez.carlos.myapplication.component.BotonesNavegacion
import gonzalez.carlos.myapplication.component.IndicadorProgresoPrenda
import gonzalez.carlos.myapplication.data.ClothingItem
import gonzalez.carlos.myapplication.data.OutfitItem
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.ui.theme.*

@Composable
fun OutfitDiarioPaso1Screen(
    onBackClick: () -> Unit = {},
    onContinue: (camisa: ClothingItem, pantalon: ClothingItem) -> Unit = { _, _ -> }
) {
    var searchQuery by remember { mutableStateOf("") }

    val camisas = sampleClothingItems.filter {
        (it.category.equals("CAMISAS", true) || it.category.equals("PLAYERAS", true)) &&
        (searchQuery.isEmpty() || it.title.contains(searchQuery, ignoreCase = true) || it.brand.contains(searchQuery, ignoreCase = true) || it.tags.any { tag -> tag.contains(searchQuery, ignoreCase = true) })
    }

    val pantalones = sampleClothingItems.filter {
        it.category.equals("PANTALONES", true) &&
        (searchQuery.isEmpty() || it.title.contains(searchQuery, ignoreCase = true) || it.brand.contains(searchQuery, ignoreCase = true) || it.tags.any { tag -> tag.contains(searchQuery, ignoreCase = true) })
    }

    var selectedCamisa by remember { mutableStateOf<ClothingItem?>(null) }
    var selectedPantalon by remember { mutableStateOf<ClothingItem?>(null) }

    Column(Modifier.fillMaxSize().background(BackgroundCream)) {
        IndicadorProgresoPrenda(pasoActual = 1, totalPasos = 2)
        DailyOutfitHeader(onBackClick)
        Text("Registra tu look de hoy", Modifier.fillMaxWidth().padding(horizontal = 20.dp), fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = DarkBrown)
        Text("Selecciona una prenda de cada categoría.", Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 6.dp), fontFamily = PlusJakartaSansFontFamily, fontSize = 14.sp, color = MediumBrown)

        Spacer(Modifier.height(4.dp))
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            placeholder = "Buscar camisas, pantalones...",
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(10.dp))

        Column(Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
            ClothingCategory(
                title = "Camisas",
                items = camisas,
                selected = selectedCamisa,
                onSelect = { clickedItem ->
                    selectedCamisa = if (selectedCamisa?.id == clickedItem.id) null else clickedItem
                }
            )
            Spacer(Modifier.height(16.dp))
            ClothingCategory(
                title = "Pantalones",
                items = pantalones,
                selected = selectedPantalon,
                onSelect = { clickedItem ->
                    selectedPantalon = if (selectedPantalon?.id == clickedItem.id) null else clickedItem
                }
            )
            Spacer(Modifier.height(12.dp))
        }
        BotonesNavegacion(
            onAtrasClick = onBackClick,
            onContinuarClick = { val camisa = selectedCamisa; val pantalon = selectedPantalon; if (camisa != null && pantalon != null) onContinue(camisa, pantalon) },
            textoAtras = "Atrás",
            textoContinuar = "Continuar",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            continuarHabilitado = selectedCamisa != null && selectedPantalon != null
        )
    }
}

@Composable
fun OutfitDiarioPaso2Screen(
    camisa: ClothingItem,
    pantalon: ClothingItem,
    onBackClick: () -> Unit = {},
    onSave: (zapato: ClothingItem?, accesorios: List<ClothingItem>) -> Unit = { _, _ -> }
) {
    var searchQuery by remember { mutableStateOf("") }

    val zapatos = sampleClothingItems.filter {
        (it.category.equals("ZAPATOS", true) || it.category.equals("CALZADO", true)) &&
        (searchQuery.isEmpty() || it.title.contains(searchQuery, ignoreCase = true) || it.brand.contains(searchQuery, ignoreCase = true) || it.tags.any { tag -> tag.contains(searchQuery, ignoreCase = true) })
    }

    val accesorios = sampleClothingItems.filter {
        it.category.equals("ACCESORIOS", true) &&
        (searchQuery.isEmpty() || it.title.contains(searchQuery, ignoreCase = true) || it.brand.contains(searchQuery, ignoreCase = true) || it.tags.any { tag -> tag.contains(searchQuery, ignoreCase = true) })
    }

    var selectedZapato by remember { mutableStateOf<ClothingItem?>(null) }
    var selectedAccesoriosIds by remember { mutableStateOf<Set<String>>(emptySet()) }

    val selectedAccesoriosList = sampleClothingItems.filter { selectedAccesoriosIds.contains(it.id) }

    Column(Modifier.fillMaxSize().background(BackgroundCream)) {
        IndicadorProgresoPrenda(pasoActual = 2, totalPasos = 2)
        DailyOutfitHeader(onBackClick)
        Column(Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
            Text("Completa tu outfit", fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = DarkBrown)
            Text("Elige los zapatos y accesorios para tu look de hoy.", Modifier.padding(top = 6.dp, bottom = 10.dp), fontFamily = PlusJakartaSansFontFamily, fontSize = 14.sp, color = MediumBrown)

            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                placeholder = "Buscar calzado o accesorios..."
            )

            Spacer(Modifier.height(14.dp))
            Text("Tu selección", fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = DarkBrown)
            Spacer(Modifier.height(8.dp))
            SelectedClothing(camisa)
            Spacer(Modifier.height(8.dp))
            SelectedClothing(pantalon)
            if (selectedZapato != null) {
                Spacer(Modifier.height(8.dp))
                SelectedClothing(selectedZapato!!)
            }
            selectedAccesoriosList.forEach { acc ->
                Spacer(Modifier.height(8.dp))
                SelectedClothing(acc)
            }

            Spacer(Modifier.height(18.dp))

            ClothingCategory(
                title = "Zapatos",
                items = zapatos,
                selected = selectedZapato,
                onSelect = { clickedItem ->
                    selectedZapato = if (selectedZapato?.id == clickedItem.id) null else clickedItem
                }
            )

            Spacer(Modifier.height(16.dp))

            ClothingCategoryMulti(
                title = "Accesorios (opcional)",
                items = accesorios,
                selectedIds = selectedAccesoriosIds,
                onToggleSelect = { clickedItem ->
                    selectedAccesoriosIds = if (selectedAccesoriosIds.contains(clickedItem.id)) {
                        selectedAccesoriosIds - clickedItem.id
                    } else {
                        selectedAccesoriosIds + clickedItem.id
                    }
                }
            )

            Spacer(Modifier.height(12.dp))
        }
        BotonesNavegacion(
            onAtrasClick = onBackClick,
            onContinuarClick = { onSave(selectedZapato, selectedAccesoriosList) },
            textoAtras = "Atrás",
            textoContinuar = "Guardar Outfit de hoy",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            continuarHabilitado = selectedZapato != null
        )
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String = "Buscar prendas...",
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
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
                if (query.isEmpty()) {
                    Text(
                        text = placeholder,
                        fontFamily = PlusJakartaSansFontFamily,
                        fontSize = 14.sp,
                        color = TextPlaceholder
                    )
                }
                BasicTextField(
                    value = query,
                    onValueChange = onQueryChange,
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

@Composable
private fun DailyOutfitHeader(onBackClick: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = onBackClick, modifier = Modifier.size(36.dp)) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Regresar", tint = DarkBrown)
        }
        Text("Outfit diario", Modifier.weight(1f), fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = DarkBrown, textAlign = TextAlign.Center)
        Spacer(Modifier.size(36.dp))
    }
}

@Composable
private fun ClothingCategory(
    title: String,
    items: List<ClothingItem>,
    selected: ClothingItem?,
    onSelect: (ClothingItem) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = DarkBrown)
        if (selected != null) {
            Text(
                text = "Toca para deseleccionar",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                color = MediumBrown
            )
        }
    }
    Spacer(Modifier.height(8.dp))
    if (items.isEmpty()) {
        Text("No se encontraron prendas para tu búsqueda.", fontFamily = PlusJakartaSansFontFamily, fontSize = 13.sp, color = MediumBrown)
    } else {
        Row(
            modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items.forEach { item ->
                val isSelected = selected?.id == item.id
                val outfitCardItem = OutfitItem(
                    id = item.id,
                    title = item.title,
                    category = item.category,
                    itemsCountText = "${item.brand} · Talla ${item.size}",
                    tags = item.tags,
                    dotColor = item.dotColor
                )
                Box(Modifier.width(160.dp)) {
                    OutfitCard(
                        item = outfitCardItem,
                        onClick = { onSelect(item) },
                        onFavoriteToggle = {},
                        selectionMode = true,
                        isSelected = isSelected
                    )
                }
            }
        }
    }
}

@Composable
private fun ClothingCategoryMulti(
    title: String,
    items: List<ClothingItem>,
    selectedIds: Set<String>,
    onToggleSelect: (ClothingItem) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = DarkBrown)
        if (selectedIds.isNotEmpty()) {
            Text(
                text = "${selectedIds.size} seleccionados (Toca para quitar)",
                fontFamily = PlusJakartaSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                color = MediumBrown
            )
        }
    }
    Spacer(Modifier.height(8.dp))
    if (items.isEmpty()) {
        Text("No se encontraron accesorios.", fontFamily = PlusJakartaSansFontFamily, fontSize = 13.sp, color = MediumBrown)
    } else {
        Row(
            modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items.forEach { item ->
                val isSelected = selectedIds.contains(item.id)
                val outfitCardItem = OutfitItem(
                    id = item.id,
                    title = item.title,
                    category = item.category,
                    itemsCountText = "${item.brand} · Talla ${item.size}",
                    tags = item.tags,
                    dotColor = item.dotColor
                )
                Box(Modifier.width(160.dp)) {
                    OutfitCard(
                        item = outfitCardItem,
                        onClick = { onToggleSelect(item) },
                        onFavoriteToggle = {},
                        selectionMode = true,
                        isSelected = isSelected
                    )
                }
            }
        }
    }
}

@Composable
private fun SelectedClothing(item: ClothingItem) {
    Surface(Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), color = FieldBackground, border = BorderStroke(1.5.dp, LightBrownBorder)) {
        Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.Checkroom, null, tint = MediumBrown, modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(10.dp))
            Column {
                Text(item.title, fontFamily = PlusJakartaSansFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, color = DarkBrown)
                Text(item.category.lowercase().replaceFirstChar { it.uppercase() }, fontFamily = PlusJakartaSansFontFamily, fontSize = 11.sp, color = MediumBrown)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OutfitDiarioPaso1Preview() { OutfitDiarioPaso1Screen() }

@Preview(showBackground = true)
@Composable
private fun OutfitDiarioPaso2Preview() { OutfitDiarioPaso2Screen(sampleClothingItems[0], sampleClothingItems[2]) }
