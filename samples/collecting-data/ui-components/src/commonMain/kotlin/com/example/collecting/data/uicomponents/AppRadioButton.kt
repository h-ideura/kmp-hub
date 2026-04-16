package com.example.collecting.data.uicomponents

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
