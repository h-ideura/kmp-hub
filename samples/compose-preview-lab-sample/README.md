# Compose Preview Lab Sample

[English](README.en.md) · 日本語

Compose Multiplatform で、コンポーネントのプレビューをよりインタラクティブに確認するためのライブラリ [Compose Preview Lab](https://github.com/tbsten/compose-preview-lab) のサンプルプロジェクトです。

## 特徴

- **インタラクティブなプレビュー**: `PreviewLab` を使用することで、プレビュー上で引数を動的に変更して UI の変化を確認できます。
- **プレビューギャラリー**: プロジェクト内の `@Preview` が付いたコンポーネントを一覧表示するギャラリー画面を表示します。
- **マルチプラットフォーム対応**: Android, iOS, Desktop (JVM), Web (Wasm/JS) で動作します。

## 使い方

### 1. インタラクティブなプレビューの作成

`PreviewLab` ブロック内で `fieldValue` を使用して、プレビュー上で変更可能な値を定義します。

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

利用可能なフィールドタイプ:
- `StringField`
- `BooleanField`
- `ColorField`
- など

### 2. プレビューギャラリーの表示

`collectAllModulePreviews()` を使用して、プロジェクト内のすべてのプレビューを取得し、`PreviewLabGallery` で表示します。

```kotlin
private val allPreviews by collectAllModulePreviews()

@Composable
fun App() {
    MaterialTheme {
        PreviewLabGallery(previewList = allPreviews)
    }
}
```

## 実行方法

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
Xcode で `iosApp` ディレクトリを開き、実行してください。

---

詳細については [Compose Preview Lab リポジトリ](https://github.com/tbsten/compose-preview-lab) を参照してください。
