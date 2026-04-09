# metro-sample

[日本語](README.md) · English

A Compose Multiplatform (CMP) sample app using [Metro DI](https://github.com/ZacSweers/metro).

## Overview

A simple app that lists GitHub users and shows user details via the GitHub API.  
It uses [Metro](https://github.com/ZacSweers/metro) by Zac Sweers as the dependency injection library.

## Tech stack

- **UI**: Compose Multiplatform (Android / iOS)
- **DI**: Metro (Dependency Injection)
- **Networking**: Ktor Client
- **Serialization**: Kotlinx Serialization (JSON)
- **Architecture**: Multi-module, MVVM
- **Navigation**: Type-safe Jetpack Navigation (Compose Multiplatform)
- **Concurrency**: Kotlin Coroutines & Flow

## Project structure

The project uses a multi-module layout.

- `:composeApp`: Main app module — platform entry points, DI graph definition, and screen integration.
- `:feature`: Feature modules for screens.
  - `:feature:list`: User list screen.
  - `:feature:detail`: User detail screen.
- `:domain`: Business logic and repository interfaces.
- `:data`: Repository implementations and the API client (GitHub API).
- `:core:model`: Shared data models across the project.

## Using Metro for DI

Metro wires dependencies across modules.

- `@DependencyGraph`: Defines the app-wide DI graph (`AppGraph`).
- `@ContributesTo`: Adds a module to the DI graph (e.g. `DataModule`).
- `@Inject`: Dependency injection.
- `@Provides`: Defines how instances are created.

## Implementation status

- [x] Project structure setup
- [x] Metro DI integration
- [x] Data fetching with GitHub API (Ktor)
- [x] User list screen
- [x] User detail screen
- [x] Type-safe Navigation
- [ ] Metrox ViewModel integration
- [ ] Stronger error handling
- [ ] Unit tests
