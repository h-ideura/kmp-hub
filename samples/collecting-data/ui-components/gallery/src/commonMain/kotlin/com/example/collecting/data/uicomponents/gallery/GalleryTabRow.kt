package com.example.collecting.data.uicomponents.gallery

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.collecting.data.uicomponents.DesignSystemComponentData

@Composable
internal fun GalleryTabRow(
    selectedType: DesignSystemComponentData.Type,
    onSelectType: (DesignSystemComponentData.Type) -> Unit,
    modifier: Modifier = Modifier,
) {
    val types = DesignSystemComponentData.Type.entries
    PrimaryTabRow(
        selectedTabIndex = types.indexOf(selectedType),
        modifier = modifier.fillMaxWidth(),
    ) {
        types.forEach { type ->
            Tab(
                selected = selectedType == type,
                onClick = { onSelectType(type) },
                text = { Text(type.name) },
            )
        }
    }
}
