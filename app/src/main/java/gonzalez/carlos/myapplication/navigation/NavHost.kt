package gonzalez.carlos.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import gonzalez.carlos.myapplication.data.sampleClothingItems
import gonzalez.carlos.myapplication.data.sampleOutfitItems
import gonzalez.carlos.myapplication.screens.*

@Composable
fun AppNavigation(
    innerPadding: PaddingValues = PaddingValues(),
    navController: NavHostController = rememberNavController()
) {
    val navigateToTab: (Int) -> Unit = { tabIndex ->
        val targetRoute: Any = when (tabIndex) {
            0 -> ArmarioRoute
            1 -> OutfitsRoute
            2 -> InicioRoute
            3 -> ProfileRoute
            else -> ArmarioRoute
        }
        navController.navigate(targetRoute) {
            popUpTo<ArmarioRoute> { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = LoginRoute,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable<LoginRoute> {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(RegisterRoute)
                },
                onLoginSuccess = {
                    navController.navigate(InicioRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                },
                onBiometricAuth = {
                    navController.navigate(InicioRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                }
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    navController.navigate(InicioRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                }
            )
        }

        composable<ArmarioRoute> {
            ClosetScreen(
                onItemClick = { item ->
                    navController.navigate(DetallePrendaRoute(item.id))
                },
                onAddClick = {
                    navController.navigate(RegistrarPrendaRoute)
                },
                onProfileClick = {
                    navigateToTab(3)
                },
                selectedNavTab = 0,
                onNavTabSelected = navigateToTab
            )
        }

        composable<DetallePrendaRoute> { backStackEntry ->
            val detail: DetallePrendaRoute = backStackEntry.toRoute()
            val item = sampleClothingItems.find { it.id == detail.itemId } ?: sampleClothingItems.first()

            DetallePrendaScreen(
                item = item,
                onBackClick = { navController.popBackStack() },
                onEditClick = { navController.navigate(EditarPrendaRoute(item.id)) },
                selectedNavTab = 0,
                onNavTabSelected = navigateToTab
            )
        }

        composable<EditarPrendaRoute> { backStackEntry ->
            val detail: EditarPrendaRoute = backStackEntry.toRoute()
            val item = sampleClothingItems.find { it.id == detail.itemId } ?: sampleClothingItems.first()

            EditarPrendaScreen(
                item = item,
                onBackClick = { navController.popBackStack() },
                onSaveSuccess = { navController.popBackStack() },
                selectedNavTab = 0,
                onNavTabSelected = navigateToTab
            )
        }

        composable<RegistrarPrendaRoute> {
            RegistrarPrendaScreen(
                onAtrasClick = { navController.popBackStack() },
                onContinuarClick = { navController.navigate(RegistrarPrendaRoute2) }
            )
        }

        composable<RegistrarPrendaRoute2> {
            RegistrarPrendaPaso2(
                onAtrasClick = { navController.popBackStack() },
                onContinuarClick = { navController.navigate(RegistrarPrendaRoute3) }
            )
        }

        composable<RegistrarPrendaRoute3> {
            RegistrarPrendaPaso3(
                onAtrasClick = { navController.popBackStack() },
                onContinuarClick = {
                    navController.navigate(ArmarioRoute) {
                        popUpTo<ArmarioRoute> { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<ProfileRoute> {
            ProfileScreen(
                onBackClick = { navController.popBackStack() },
                onLogoutClick = {
                    navController.navigate(LoginRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                },
                selectedNavTab = 3,
                onNavTabSelected = navigateToTab
            )
        }

        composable<InicioRoute> {
            MainScreen(
                onItemClick = { item ->
                    navController.navigate(DetallePrendaRoute(item.id))
                },
                onOutfitClick = { outfit ->
                    navController.navigate(DetalleOutfitRoute(outfit.id))
                },
                onSeeAllClothesClick = {
                    navigateToTab(0)
                },
                onSeeAllOutfitsClick = {
                    navigateToTab(1)
                },
                onAddClick = {
                    navController.navigate(RegistrarPrendaRoute)
                },
                onDailyOutfitClick = { navController.navigate(OutfitDiarioPaso1Route) },
                onProfileClick = {
                    navigateToTab(3)
                },
                selectedNavTab = 2,
                onNavTabSelected = navigateToTab
            )
        }

        composable<OutfitsRoute> {
            OutfitsScreen(
                onOutfitClick = { outfit ->
                    navController.navigate(DetalleOutfitRoute(outfit.id))
                },
                onAddClick = { navController.navigate(CrearOutfitRoute) },
                onProfileClick = { navigateToTab(3) },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<DetalleOutfitRoute> { backStackEntry ->
            val detail: DetalleOutfitRoute = backStackEntry.toRoute()
            val outfit = sampleOutfitItems.find { it.id == detail.outfitId } ?: sampleOutfitItems.first()

            DetalleOutfitScreen(
                outfit = outfit,
                onBackClick = { navController.popBackStack() },
                onEditClick = { navController.navigate(EditarOutfitRoute(outfit.id)) },
                onDeleteClick = { navController.popBackStack() },
                onItemClick = { item -> navController.navigate(DetallePrendaRoute(item.id)) },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<EditarOutfitRoute> { backStackEntry ->
            val detail: EditarOutfitRoute = backStackEntry.toRoute()
            val outfit = sampleOutfitItems.find { it.id == detail.outfitId } ?: sampleOutfitItems.first()

            EditarOutfitScreen(
                outfit = outfit,
                onBackClick = { navController.popBackStack() },
                onSaveSuccess = { navController.popBackStack() },
                onSelectFromClosetClick = { navController.navigate(SeleccionarPrendaRoute) },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<CrearOutfitRoute> {
            CrearOutfitScreen(
                onBackClick = { navController.popBackStack() },
                onSaveSuccess = { navController.popBackStack() },
                onSelectFromClosetClick = { navController.navigate(SeleccionarPrendaRoute) },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<SeleccionarPrendaRoute> {
            SeleccionarPrenda(
                onBackClick = { navController.popBackStack() },
                onItemClick = { navController.popBackStack() },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<OutfitDiarioPaso1Route> {
            OutfitDiarioPaso1Screen(
                onBackClick = { navController.popBackStack() },
                onContinue = { camisa, pantalon ->
                    navController.navigate(OutfitDiarioPaso2Route(camisa.id, pantalon.id))
                }
            )
        }

        composable<OutfitDiarioPaso2Route> { backStackEntry ->
            val route: OutfitDiarioPaso2Route = backStackEntry.toRoute()
            val prendas = gonzalez.carlos.myapplication.data.sampleClothingItems
            val camisa = prendas.find { it.id == route.camisaId } ?: prendas.first()
            val pantalon = prendas.find { it.id == route.pantalonId } ?: prendas.first()
            OutfitDiarioPaso2Screen(
                camisa = camisa,
                pantalon = pantalon,
                onBackClick = { navController.popBackStack() },
                onSave = { navController.navigate(InicioRoute) { popUpTo<InicioRoute> { inclusive = false }; launchSingleTop = true } }
            )
        }
    }
}
