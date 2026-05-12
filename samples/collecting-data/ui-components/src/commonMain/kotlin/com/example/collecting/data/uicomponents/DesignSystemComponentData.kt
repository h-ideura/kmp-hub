package com.example.collecting.data.uicomponents

import androidx.compose.runtime.Composable

data class DesignSystemComponentData(
    val name: String,
    val type: Type,
    val content: @Composable () -> Unit,
) {
    enum class Type {
        Component,
        Screen,
    }
}
