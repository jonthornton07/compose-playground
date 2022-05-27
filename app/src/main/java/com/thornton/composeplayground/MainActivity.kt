package com.thornton.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.thornton.composeplayground.ui.theme.ComposePlaygroundTheme
import com.thornton.composeplayground.views.Greetings
import com.thornton.composeplayground.views.OnboardingView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                Layout()
            }
        }
    }
}

@Composable
fun Layout() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingView {
            shouldShowOnboarding = false
        }
    } else {
        Greetings()
    }
}
