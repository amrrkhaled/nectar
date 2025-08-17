package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.NectarApp
import com.example.nectar.ui.screens.ProductDetail.ProductDetailScreen
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.screens.onboarding.OnboardingScreen
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel by viewModels()
        actionBar?.hide()

        enableEdgeToEdge()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !homeViewModel.ready.value
            }
//            setKeepOnScreenCondition {
//                true
//            }
        }
        setContent {
            NectarTheme {

                NectarApp(homeViewModel)

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hellopo $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NectarTheme {
        Greeting("Android")
    }
}