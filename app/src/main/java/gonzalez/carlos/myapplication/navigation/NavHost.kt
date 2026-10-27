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
            3 -> CalendarioRoute
            4 -> ProfileRoute
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
                    navController.navigate(ArmarioRoute) {
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
                    navController.navigate(ArmarioRoute) {
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


        composable<CalendarioRoute> {
            CalendarScreen(
                selectedNavTab = 3,
                onNavTabSelected = navigateToTab,
                onBackClick = { navController.popBackStack() }
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
                selectedNavTab = 4,
                onNavTabSelected = navigateToTab
            )
        }

        composable<InicioRoute> {
            MainScreen(
                onItemClick = { item ->
                    navController.navigate(DetallePrendaRoute(item.id))
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
                selectedNavTab = 2,
                onNavTabSelected = navigateToTab
            )
        }

        composable<OutfitsRoute> {
            OutfitsScreen(
                onBackClick = { navController.popBackStack() },
                onAddClick = { navController.navigate(CrearOutfitRoute) },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }

        composable<CrearOutfitRoute> {
            CrearOutfitScreen(
                onBackClick = { navController.popBackStack() },
                onSaveSuccess = { navController.popBackStack() },
                selectedNavTab = 1,
                onNavTabSelected = navigateToTab
            )
        }
    }
}
