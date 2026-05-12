# Compose Preview Lab Sample

[日本語](README.md) · English

A sample project for [Compose Preview Lab](https://github.com/tbsten/compose-preview-lab), a library for more interactive component previews in Compose Multiplatform.

## Features

- **Interactive Previews**: Use `PreviewLab` to dynamically change arguments in previews and see UI changes in real-time.
- **Preview Gallery**: Displays a gallery screen listing all `@Preview` annotated components in the project.
- **Multiplatform Support**: Works on Android, iOS, Desktop (JVM), and Web (Wasm/JS).

## Usage

### 1. Creating an Interactive Preview

Use `fieldValue` within a `PreviewLab` block to define values that can be changed in the preview.

```kotlin
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
```

Available field types:
- `StringField`
- `BooleanField`
- `ColorField`
- and more

### 2. Displaying the Preview Gallery

Use `collectAllModulePreviews()` to get all previews in the project and display them with `PreviewLabGallery`.

```kotlin
private val allPreviews by collectAllModulePreviews()

@Composable
fun App() {
    MaterialTheme {
        PreviewLabGallery(previewList = allPreviews)
    }
}
```

## How to Run

### Android
```shell
./gradlew :composeApp:assembleDebug
```

### Desktop (JVM)
```shell
./gradlew :composeApp:run
```

### Web (Wasm)
```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### iOS
Open the `iosApp` directory in Xcode and run it.

---

For more details, please refer to the [Compose Preview Lab repository](https://github.com/tbsten/compose-preview-lab).
