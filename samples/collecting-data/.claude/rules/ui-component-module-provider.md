---
paths:
  - ui-components/**/*.kt
---

# ui-components: Composable 作成時の Module 定義ルール

新しい `@Composable` コンポーネントを作成した場合、同一ファイル内に Metro DI 用の Module を定義して `DesignSystemComponentData` を provide すること。

## パターン

```kotlin
@ContributesTo(AppScope::class)
@BindingContainer
object <ComponentName>Module {
    @Provides
    @IntoSet
    fun provide(): DesignSystemComponentData = DesignSystemComponentData(
        name = "<ComponentName>",
        type = DesignSystemComponentData.Type.Component,
        content = { <ComponentName>(/* サンプル引数 */) },
    )
}
```

## ルール

- Module は Composable 関数と **同じファイル内** に定義する (別ファイルにしない)
- `content` ラムダにはコンポーネントの代表的な使用例をサンプル引数付きで記述する
- `@BindingContainer object` 形式を使う
- import は `dev.zacsweers.metro.*` から `AppScope`, `BindingContainer`, `ContributesTo`, `Provides`, `IntoSet`
