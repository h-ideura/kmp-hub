# metro-sample

[Metro DI](https://github.com/ZacSweers/metro) を使用した Compose Multiplatform (CMP) サンプルアプリです。

## 概要
GitHub API を使用してユーザー一覧と詳細を表示するシンプルなアプリです。
DI (Dependency Injection) ライブラリとして、Zac Sweers 氏による [Metro](https://github.com/ZacSweers/metro) を導入しています。

## 技術スタック
- **UI**: Compose Multiplatform (Android / iOS)
- **DI**: Metro (Dependency Injection)
- **Networking**: Ktor Client
- **Serialization**: Kotlinx Serialization (JSON)
- **Architecture**: Multi-module, MVVM
- **Navigation**: Type-safe Jetpack Navigation (Compose Multiplatform)
- **Concurrency**: Kotlin Coroutines & Flow

## プロジェクト構成
マルチモジュール構成を採用しています。

- `:composeApp`: メインアプリモジュール。プラットフォーム固有のエントリポイントと DI グラフの定義、画面の統合。
- `:feature`: 機能ごとの画面実装モジュール。
    - `:feature:list`: ユーザー一覧画面。
    - `:feature:detail`: ユーザー詳細画面。
- `:domain`: ビジネスロジックと Repository インターフェース。
- `:data`: Repository 実装と API クライアント (GitHub API)。
- `:core:model`: プロジェクト全体で共有されるデータモデル。

## DI (Metro) の使用
Metro を使用して、各モジュール間で依存関係を管理しています。

- `@DependencyGraph`: アプリ全体の DI グラフを定義 (`AppGraph`)。
- `@ContributesTo`: モジュールを DI グラフに追加 (`DataModule` など)。
- `@Inject`: 依存関係の注入。
- `@Provides`: インスタンスの生成方法を定義。

## 実装状況
- [x] プロジェクト構成のセットアップ
- [x] Metro DI の導入
- [x] GitHub API を使用したデータ取得 (Ktor)
- [x] ユーザー一覧画面の実装
- [x] ユーザー詳細画面の実装
- [x] Type-safe Navigation の導入
- [ ] Metrox ViewModel の導入
- [ ] エラーハンドリングの強化
- [ ] ユニットテストの追加
