package com.example.nectar.ui.screens.onboarding

import android.R.attr.bottom
import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.nectar.R
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.SearchTextColor
import com.example.nectar.ui.theme.White
import com.example.nectar.ui.theme.onBoardingText

@Composable
fun OnboardingScreen(
    onGetStarted: () -> Unit = {},
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.on_boarding), // your drawable image
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // scales the image to cover the whole screen
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_carrot_white),
                contentDescription = "Onboarding Icon",
                tint = White,
                modifier = Modifier.padding(
                    top = 470.dp,
                    bottom = 35.dp
                ) // Adjust padding as needed


            )

            Text(
                text = "Welcome",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = White
            )

            Spacer(modifier = Modifier.height(8.dp)) // space between lines

            Text(
                text = "to our store",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = White
            )
            Text(
                text = "Get your groceries in as fast as one hour",
                style = MaterialTheme.typography.bodyLarge,
                color = onBoardingText,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 19.dp) // padding

            )
            WideButton(
                text = "Get Started",
                onClick = onGetStarted,
                modifier = Modifier.padding(top = 40.dp, bottom = 60.dp),

                )
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    NectarTheme {
        OnboardingScreen()
    }
}
