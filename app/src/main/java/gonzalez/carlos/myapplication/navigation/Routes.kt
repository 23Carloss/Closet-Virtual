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
object RegistrarPrendaRoute

@Serializable
object CalendarioRoute

@Serializable
object ProfileRoute

@Serializable
object OutfitsRoute

@Serializable
object CrearOutfitRoute

@Serializable
object InicioRoute