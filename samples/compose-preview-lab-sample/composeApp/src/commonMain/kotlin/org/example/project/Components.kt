package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import me.tbsten.compose.preview.lab.previewlab.PreviewLab
import me.tbsten.compose.preview.lab.field.StringField
import me.tbsten.compose.preview.lab.field.BooleanField
import me.tbsten.compose.preview.lab.field.ColorField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun MyButtonPreview() = PreviewLab {
    val text = fieldValue { StringField("Text", "Click Me") }
    val enabled = fieldValue { BooleanField("Enabled", true) }

    MyButton(
        text = text,
        enabled = enabled,
        onClick = {},
    )
}

@Composable
fun MyCard(
    title: String,
    description: String,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun MyCardPreview() = PreviewLab {
    val title = fieldValue { StringField("Title", "Card Title") }
    val description = fieldValue { StringField("Description", "This is a sample card description.") }
    val color = fieldValue { ColorField("Background Color", Color.White) }

    MyCard(
        title = title,
        description = description,
        backgroundColor = color,
    )
}

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun MyTextFieldPreview() = PreviewLab {
    val label = fieldValue { StringField("Label", "Username") }
    val initialValue = fieldValue { StringField("Initial Value", "John Doe") }

    MyTextField(
        value = initialValue,
        onValueChange = {},
        label = label,
    )
}

@Composable
fun MyText(
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = Color.Unspecified,
) {
    Text(
        text = text,
        style = style,
        color = color,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun MyTextPreview() = PreviewLab {
    val text = fieldValue { StringField("Text", "Hello, Preview Lab!") }
    val color = fieldValue { ColorField("Color", Color.Black) }

    MyText(
        text = text,
        color = color,
    )
}
