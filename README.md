# kmp-hub

[English](README.en.md) · 日本語

学習や参考に利用するための個人的なKMPのサンプル集。

# サンプルリンク集

## Wizard

### KMP Wizard(JetBrains公式)
公式のWizard。KMPプロジェクトの雛形を作成できる。  
https://kmp.jetbrains.com/

### KMP Wizard(terrakok製)
非公式のterrakok製Wizard。ライブラリ追加なども行える。  
https://terrakok.github.io/kmp-web-wizard/

## ライブラリ
### KMPライブラリカタログ(Kotlin公式)
KMPで利用できるライブラリのカタログ。  
https://klibs.io/

### KMP Awesome
KMPで利用できる・よく使用されているライブラリがまとまっている  
https://github.com/terrakok/kmp-awesome

## サンプルプロジェクト

### CMPサンプル集（JetBrains公式）
https://github.com/JetBrains/compose-multiplatform/tree/master/examples

## PeopleInSpace
Android,iOSのネイティブUIだけでなく、ウィジェット、デスクトップなどを含んだマルチモジュール構成のサンプルプロジェクト  
https://github.com/joreilly/PeopleInSpace

# 開発者向け情報

## 運用方針・ルール

- **誰でも作成歓迎**
    - 過去のIssueを参考に別手法で実装したサンプルなども歓迎します。
    - 「実装を試みたができなかった」という失敗例の共有も歓迎します。
- **既存サンプル・一般的なもの**
    - すでに公開されているサンプルや、ありきたりな内容については、できるだけ本READMEの「サンプルリンク集」への追加に留めてください。
- **リポジトリへの追加基準**
    - 世の中にコード例が少ないサンプルを優先的にリポジトリへ追加します。
    - 勉強目的を兼ねているため、既存のサンプルがどこかに存在していても追加して問題ありません。（多少違う実装とかでもok）
    - ただし、後のメンテナンス状況等により削除される可能性があります。
- **サンプル要望**
    - 欲しいサンプル等がある場合は、本リポジトリのIssueに追加してください。

## サンプル追加時の注意点

- **ラベルの付与**
    - 各サンプルのPRを後から見返せるよう、サンプルごとの実装（Renovateによる更新含む）には適切なラベルを付与することを原則とします。
    - GitHub Actionsの `labeler` を導入しているため、自動ラベル機能が使えます。新しいサンプルを追加した際は、そのサンプルのラベルと`.github/labeler.yml` に設定を追加してください。
- **CI（GitHub Actions）**
    - `samples/` 配下または `.github/workflows/` の変更で `.github/workflows/ci.yml` が動きます。変更のあったサンプルだけ Gradle を実行し、ワークフロー定義を変えたときは全サンプルをビルドします。
    - 実処理は再利用ワークフロー `.github/workflows/gradle-kmp-ci-reusable.yml` にまとめています。Ubuntu 上で JDK と Android SDK をセットアップし、各プロジェクトのルートで `./gradlew assembleDebug` を実行します（iOS 向けのビルドやテストは実行しません）。
    - 新しいサンプルを `samples/<名前>/` に追加したら、`.github/workflows/ci.yml` のパスフィルタと、そのサンプルを呼び出すジョブを追加してください（`ci.yml` 先頭のコメントも参照）。

## メンテナンスに関して
- 誰でもいつでもok
- 定期的なメンテも一応あります