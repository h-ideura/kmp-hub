package com.example.collecting.data.uicomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Provides

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 8.dp),
    )
}

@ContributesTo(AppScope::class)
@BindingContainer
object SectionTitleModule {
    @Provides
    @IntoSet
    fun provide(): DesignSystemComponentData = DesignSystemComponentData(
        name = "SectionTitle",
        type = DesignSystemComponentData.Type.Component,
        content = { SectionTitle("Int1") },
    )
}
