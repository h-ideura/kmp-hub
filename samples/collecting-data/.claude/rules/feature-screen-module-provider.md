---
paths:
  - feature/**/*.kt
---

# feature: Screen 作成時の Module 定義ルール

新しい `@Composable` Screen を作成した場合、同一ファイル内に Metro DI 用の Module を定義して `DesignSystemComponentData` を provide すること。

## パターン

```kotlin
@ContributesTo(AppScope::class)
@BindingContainer
object <ScreenName>Module {
    @Provides
    @IntoSet
    fun provide<ScreenName>(): DesignSystemComponentData = DesignSystemComponentData(
        name = "<ScreenName>",
        type = DesignSystemComponentData.Type.Screen,
        content = { <ScreenName>() },
    )
}
```

## ルール

- Module は Composable 関数と **同じファイル内** に定義する (別ファイルにしない)
- `content` ラムダにはスクリーンの代表的な表示例を記述する
- `@BindingContainer object` 形式を使う
- import は `dev.zacsweers.metro.*` から `AppScope`, `ContributesTo`, `Provides`, `IntoSet`, `BindingContainer`
