# cmp-swift-sample

このプロジェクトは、Compose Multiplatform (CMP) のコンポーネントを SwiftUI から利用する場合の実装例を集めたサンプルプロジェクトです。

## 特徴
- **リアクティブな状態管理**: SwiftUI の `@State` などのネイティブな状態管理と、Compose Multiplatform の UI をシームレスに同期させる実装例です。
- **UIViewControllerRepresentable の活用**: SwiftUI から CMP コンポーネントを呼び出す際のブリッジ層として `UIViewControllerRepresentable` を使用しています。
- **共有コンポーネントの単体利用**: アプリ全体を Compose で構築するのではなく、特定の画面やコンポーネントのみを Compose で実装し、既存のネイティブアプリに組み込む手法を示しています。

## 現状の実装
- **UserList**: 共有モジュールで実装された Compose コンポーネントを、SwiftUI からリアクティブに表示・操作するサンプルです。
  - SwiftUI 側でユーザーリストの状態を保持し、その変更が即座に Compose UI に反映されます。
  - Compose UI 側の削除操作（コールバック）を SwiftUI 側で受け取り、SwiftUI の状態を更新します。

---

## プロジェクト構造

* [/composeApp](./composeApp/src) は Android アプリケーション用のコードが含まれています。
  - Android 側でも `MainActivity` で状態を管理し、共有の `UserList` を呼び出しています。
* [/iosApp](./iosApp/iosApp) は iOS アプリケーション（SwiftUI）が含まれています。CMP のコンポーネントを呼び出すエントリポイントです。
  - `ContentView.swift` で `UIViewControllerRepresentable` を介して `UserList` を呼び出しています。
* [/shared](./shared/src) は全ターゲット間で共有されるコードが含まれています。
  - [commonMain](./shared/src/commonMain/kotlin) に共有の Compose UI (`UserList.kt`) が実装されています。
  - [iosMain](./shared/src/iosMain/kotlin) に SwiftUI の `updateUIViewController` からの更新を受け取り、Compose の状態にブリッジするためのラッパー (`PlatformViewController.kt`) が含まれています。

### Android アプリの実行
- `./gradlew :composeApp:assembleDebug`

### iOS アプリの実行
- `iosApp` ディレクトリを Xcode で開いて実行するか、Android Studio の実行構成を使用してください。

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
