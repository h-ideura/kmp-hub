---
name: readme-bilingual-sync
description: >-
  Synchronizes Japanese and English README pairs: compares the newer edited
  version with the older one and updates the stale file when structure or
  meaning diverges. Use when maintaining README.md with README.en.md or
  README.ja.md, when the user asks to sync bilingual docs, catch up
  translations, or align JA/EN README after editing one side. Triggers:
  README 同期, 日英 README, bilingual README, README.en, README.ja.
---

# README 日英同期（Bilingual README Sync）

## 目的

日本語版と英語版の README が **どちらか一方だけ** 更新されているとき、**新しい方を正** とみなし、内容の差分を埋める形で **古い方を更新** する。単なる機械翻訳の貼り付けではなく、リポジトリの文体・用語に合わせた自然な訳文・原文にする。

## いつ適用するか

- ユーザーが「README の日本語/英語を揃えて」「片方だけ更新したので追従して」と依頼したとき
- `README.md` / `README.en.md` / `README.ja.md` のような **ペア** のメンテナンスをしているとき
- PR や差分で、片方の README だけが変わっているのを検知したとき

## 前提の確認（最初に行う）

1. **ペアのパスを特定する**  
   一般的な例（プロジェクトの慣習に合わせて読み替える）:
   - `README.md`（日本語）+ `README.en.md`（英語）
   - `README.ja.md` + `README.md`（英語メイン）
   - `samples/foo/README.md` + `samples/foo/README.en.md`
2. **どちらが「新しい方」か** を決める。優先順位:
   - ユーザーが明示した場合 → それに従う
   - 未指定なら **git の最終変更時刻**（`git log -1 --format=%ct -- <path>`）が新しい方を「ソース」にする
   - 時刻が同じ・取得できない場合は **ユーザーに確認** する
3. **スコープ** を確認する: リポジトリ直下だけか、`samples/**` など複数ペアがあるか。

## 作業手順

### 1. ソースとターゲットを決める

- **ソース**: 新しく編集された方（正とする内容）
- **ターゲット**: 更新が必要な方（古い方）

### 2. 差分の種類を分類する

読み取り専用で両方を読み、ソース相对でターゲットにない／古い内容を列挙する:

| 差分の種類 | ターゲット側での対応 |
|------------|----------------------|
| 見出し・セクションの追加/削除/順序変更 | 同じ構成に合わせる（見出しレベルも揃える） |
| 段落・説明の追加・修正 | 意味を対応言語で反映（訳または原文作成） |
| 箇条書き・手順番号 | 項目数・階層を一致させる |
| コードブロック・コマンド | **原則そのまま**（言語タグ・内容を維持）。コメントのみ対応言語で揃える必要があればソースに合わせる |
| リンク・パス・ファイル名 | 同一の URL/パスを維持。説明テキストだけ言語に合わせる |
| 表 | 列の対応を保ち、セル内容を翻訳または原文で揃える |
| 図・スクリーンショットの参照 | ファイル名は変えない。キャプションのみ言語に合わせる |

### 3. ターゲットを編集する

- **ソースの情報量を落とさない**: 省略・要約で済ませない（プロジェクトが意図的に短文化している場合を除き、ユーザーに確認）
- **ターゲット固有で正しい慣習** を維持: 例として英語 README では「you」、日本語では「です・ます」、既存の用語訳があればそれに合わせる
- **Front matter**（`---` で始まる YAML）がある場合は、キー構造を揃え、値は言語に応じて訳す

### 4. 変更が不要な場合

ソースとターゲットが **意味・構成ともに同等** なら、ファイルを書き換えず **「既に同期済み」** と報告する。

### 5. 完了報告

- 更新したファイルパス
- ソースにしたファイル
- 主な変更内容（セクション単位で簡潔に）

## 品質ルール

- **用語の一貫性**: 同じ概念は README 内で表記を統一する（既存の見出し・リンク先の名前に合わせる）
- **技術名**（Kotlin, Gradle, API 名など）は一般に原文のまま。日本語 README では必要に応じて短い補足だけ足す
- **断定と注意書き** の強さ（must / should / optional）をソースと同じにする
- 不確実な仕様は推測で埋めず、コメントや Issue への誘導、またはユーザーに確認

## よくある落とし穴

- **片方だけ** にある「ローカルな注意書き」を見落とす → セクション見出しの一覧を両方取って比較する
- **サンプルパス** が `samples/...` とルートで重複している → 編集対象のディレクトリを間違えない
- **英語版がメイン** のプロジェクトでは `README.md` が英語、`README.ja.md` が日本語、など **命名ルールをファイル名から推測** し、逆転させない

## リポジトリ内での配置

このスキルは本リポジトリの `.agents/skills/readme-bilingual-sync/SKILL.md` に配置されている。

## 参照コマンド例（エージェント用）

新しい方の判定に git を使う場合:

```bash
git log -1 --format='%h %ci %s' -- README.md
git log -1 --format='%h %ci %s' -- README.en.md
```

内容比較:

```bash
git diff --no-index README.md README.en.md
# または既に追跡されている場合
git diff README.md README.en.md
```

（実際のファイル名はプロジェクトに合わせて読み替える。）
