package com.example.collecting.data.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Provides

@Composable
fun AppCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
    )
}

@ContributesTo(AppScope::class)
@BindingContainer
object AppCheckboxModule {
    @Provides
    @IntoSet
    fun provide(): DesignSystemComponentData = DesignSystemComponentData(
        name = "AppCheckbox",
        type = DesignSystemComponentData.Type.Component,
        content = { AppCheckbox(checked = true, onCheckedChange = {}) },
    )
}
