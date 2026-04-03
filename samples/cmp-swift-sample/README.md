# cmp-swift-sample

このプロジェクトは、Compose Multiplatform (CMP) のコンポーネントを SwiftUI から利用する場合の実装例を集めたサンプルプロジェクトです。

## 現状の実装
- **UserList**: 共有モジュールで実装された Compose コンポーネントを、SwiftUI の `UIViewControllerRepresentable` を介して表示する単一コンポーネントの利用例です。

---

## プロジェクト構造

* [/composeApp](./composeApp/src) は Android アプリケーション用のコードが含まれています。
* [/iosApp](./iosApp/iosApp) は iOS アプリケーション（SwiftUI）が含まれています。CMP のコンポーネントを呼び出すエントリポイントです。
* [/shared](./shared/src) は全ターゲット間で共有されるコードが含まれています。
  - [commonMain](./shared/src/commonMain/kotlin) に共有の Compose UI (UserList など) が実装されています。
  - [iosMain](./shared/src/iosMain/kotlin) に iOS 向けに `ComposeUIViewController` を生成するコードが含まれています。

### Android アプリの実行
- `./gradlew :composeApp:assembleDebug`

### iOS アプリの実行
- `iosApp` ディレクトリを Xcode で開いて実行するか、Android Studio の実行構成を使用してください。

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
