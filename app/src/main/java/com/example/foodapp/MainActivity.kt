package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.ui.components.BottomNavigationBar
import com.example.foodapp.ui.screens.AboutScreen
import com.example.foodapp.ui.screens.DetailScreen
import com.example.foodapp.ui.screens.GridScreen
import com.example.foodapp.ui.screens.HomeScreen
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                MainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(null).value?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(150.dp)
                    )
                }
            )
        },
        bottomBar = {
            if (currentRoute != "detail/{foodId}") {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("grid") { GridScreen(navController) }
            composable("about") { AboutScreen() }
            composable("detail/{foodId}") { backStackEntry ->
                val foodId = backStackEntry.arguments?.getString("foodId")
                DetailScreen(foodId = foodId, navController = navController)
            }
        }
    }
}

