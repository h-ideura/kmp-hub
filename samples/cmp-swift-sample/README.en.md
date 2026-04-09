# cmp-swift-sample

English · [日本語](README.md)

This project is a sample that demonstrates how to use Compose Multiplatform (CMP) components from SwiftUI.

## Features
- **Reactive state management**: Shows how to keep SwiftUI’s native state (e.g. `@State`) in sync with Compose Multiplatform UI.
- **UIViewControllerRepresentable**: Uses `UIViewControllerRepresentable` as the bridge layer when calling CMP components from SwiftUI.
- **Shared components in isolation**: Instead of building the whole app in Compose, this sample embeds specific screens or components into an existing native app.

## Current implementation
- **UserList**: Displays and interacts with a shared Compose component from SwiftUI in a reactive way.
  - SwiftUI holds the user list state; changes propagate immediately to the Compose UI.
  - Delete actions from the Compose UI are handled via callbacks so SwiftUI can update its state.

---

## Project structure

* [/composeApp](./composeApp/src) — Android application code.
  - Android also manages state in `MainActivity` and calls the shared `UserList`.
* [/iosApp](./iosApp/iosApp) — iOS application (SwiftUI); entry point for calling CMP components.
  - `ContentView.swift` loads `UserList` through `UIViewControllerRepresentable`.
* [/shared](./shared/src) — Code shared across targets.
  - [commonMain](./shared/src/commonMain/kotlin) — shared Compose UI (`UserList.kt`).
  - [iosMain](./shared/src/iosMain/kotlin) — wrapper (`PlatformViewController.kt`) that bridges updates from SwiftUI’s `updateUIViewController` into Compose state.

### Run the Android app
- `./gradlew :composeApp:assembleDebug`

### Run the iOS app
- Open the `iosApp` directory in Xcode and run, or use a run configuration in Android Studio.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
