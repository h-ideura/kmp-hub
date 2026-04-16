package com.example.collecting.data.uicomponents

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Provides

@Composable
fun AppRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
    )
}

@ContributesTo(AppScope::class)
@BindingContainer
object AppRadioButtonModule {
    @Provides
    @IntoSet
    fun provide(): DesignSystemComponentData = DesignSystemComponentData(
        name = "AppRadioButton",
        type = DesignSystemComponentData.Type.Component,
        content = { AppRadioButton(selected = true, onClick = {}) },
    )
}
