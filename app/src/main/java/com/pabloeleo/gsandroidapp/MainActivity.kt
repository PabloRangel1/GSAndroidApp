package com.pabloeleo.gsandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pabloeleo.gsandroidapp.screens.EquipeScreen
import com.pabloeleo.gsandroidapp.screens.ImcScreen
import com.pabloeleo.gsandroidapp.screens.LoginScreen
import com.pabloeleo.gsandroidapp.screens.MenuScreen
import com.pabloeleo.gsandroidapp.ui.theme.GSAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            GSAndroidAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "login"
    ) {



        composable(route = "login") {
            LoginScreen(navController = navController)
        }


        composable(route = "menu") {
            MenuScreen(navController = navController)
        }


        composable(route = "imc") {
            ImcScreen(navController = navController)
        }


        composable(route = "equipe") {
            EquipeScreen(navController = navController)
        }
    }
}

