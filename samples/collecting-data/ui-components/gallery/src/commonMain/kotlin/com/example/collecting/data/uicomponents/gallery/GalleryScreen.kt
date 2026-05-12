package com.example.collecting.data.uicomponents.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collecting.data.uicomponents.DesignSystemComponentData

@Composable
fun GalleryScreen(
    components: Set<DesignSystemComponentData>,
    modifier: Modifier = Modifier,
) {
    var selectedType by remember { mutableStateOf(DesignSystemComponentData.Type.Component) }

    val filteredComponents = remember(components, selectedType) {
        components.filter { it.type == selectedType }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
    ) {
        Text(
            text = "Component Gallery",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp),
        )

        GalleryTabRow(
            selectedType = selectedType,
            onSelectType = { selectedType = it },
        )

        when (selectedType) {
            DesignSystemComponentData.Type.Screen -> GalleryScreenGrid(
                components = filteredComponents,
            )
            DesignSystemComponentData.Type.Component -> GalleryComponentList(
                components = filteredComponents,
            )
        }
    }
}
