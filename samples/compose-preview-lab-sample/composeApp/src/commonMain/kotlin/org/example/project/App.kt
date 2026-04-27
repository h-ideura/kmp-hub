package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import me.tbsten.compose.preview.lab.gallery.PreviewLabGallery
import me.tbsten.compose.preview.lab.collectAllModulePreviews
private val allPreviews by collectAllModulePreviews()

@Composable
fun App() {
    MaterialTheme {
        PreviewLabGallery(previewList = allPreviews)
    }
}