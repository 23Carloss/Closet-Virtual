package gonzalez.carlos.myapplication.navigation

import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

@Serializable
object RegisterRoute

@Serializable
object ArmarioRoute

@Serializable
data class DetallePrendaRoute(val itemId: String)

@Serializable
data class EditarPrendaRoute(val itemId: String)

@Serializable
object RegistrarPrendaRoute
@Serializable
object RegistrarPrendaRoute2

@Serializable
object RegistrarPrendaRoute3

@Serializable
object ProfileRoute

@Serializable
object OutfitsRoute

@Serializable
data class DetalleOutfitRoute(val outfitId: String)

@Serializable
data class EditarOutfitRoute(val outfitId: String)

@Serializable
object CrearOutfitRoute

@Serializable
object SeleccionarPrendaRoute

@Serializable
object InicioRoute
