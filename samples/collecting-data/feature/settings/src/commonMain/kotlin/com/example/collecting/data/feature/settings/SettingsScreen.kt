package com.example.collecting.data.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collecting.data.uicomponents.SectionTitle
import com.example.collecting.data.uicomponents.SettingsItem

@Composable
fun SettingsScreen(
    isDark: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp),
        )

        SectionTitle(
            text = "Appearance",
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        SettingsItem(
            title = "Dark Mode",
            subtitle = if (isDark) "On" else "Off",
            onClick = onToggleTheme,
            trailing = {
                Switch(
                    checked = isDark,
                    onCheckedChange = { onToggleTheme() },
                )
            },
        )

        HorizontalDivider()

        SectionTitle(
            text = "About",
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        SettingsItem(
            title = "Version",
            subtitle = "1.0.0",
        )
    }
}
