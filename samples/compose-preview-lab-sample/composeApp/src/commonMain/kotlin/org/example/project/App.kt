package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource
import me.tbsten.compose.preview.lab.previewlab.PreviewLab
import me.tbsten.compose.preview.lab.field.StringField
import me.tbsten.compose.preview.lab.gallery.PreviewLabGallery
import me.tbsten.compose.preview.lab.ExperimentalComposePreviewLabApi

import composepreviewlabsample.composeapp.generated.resources.Res
import composepreviewlabsample.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        AppContent("Click me!")
    }
}

@Composable
fun AppContent(buttonText: String) {
    var showContent by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showContent = !showContent }) {
            Text(buttonText)
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}

@Preview
@Composable
fun AppPreviewLab() = PreviewLab {
    val buttonText = fieldValue { StringField("Button Text", "Click me!") }
    MaterialTheme {
        AppContent(buttonText)
    }
}
