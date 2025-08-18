package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.nectar.ui.NectarApp
import com.example.nectar.ui.navigation.NavHostViewModel
import com.example.nectar.ui.navigation.Onboarding
import com.example.nectar.ui.navigation.Shop
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel by viewModels()
        val navHostViewModel: NavHostViewModel by viewModels()
        actionBar?.hide()

        enableEdgeToEdge()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !homeViewModel.ready.value || !navHostViewModel.ready.value

            }

        }

        setContent {

            NectarTheme {
                val isOnboardingCompleted by navHostViewModel.isOnboardingCompleted.collectAsState()
                val startDestination =
                    if (isOnboardingCompleted == false) Onboarding else Shop

                NectarApp(
                    homeViewModel,
                    navHostViewModel,
                    startDestination = startDestination
                )


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hellopo $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NectarTheme {
        Greeting("Android")
    }
}