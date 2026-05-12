package com.example.collecting.data.uicomponents.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collecting.data.uicomponents.DesignSystemComponentData

@Composable
internal fun GalleryComponentList(
    components: List<DesignSystemComponentData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        components.forEach { component ->
            GalleryItem(
                name = component.name,
                content = component.content,
                isScreen = false,
            )
        }
    }
}
