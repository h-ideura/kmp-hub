# kmp-hub

[日本語](README.md) · English

A personal collection of Kotlin Multiplatform (KMP) samples for learning and reference.

# Included Samples

See [samples/README.en.md](samples/README.en.md) for details of the samples included in this repository.

- **[metro-sample](samples/metro-sample)**: A multi-module GitHub API sample using Metro DI.
- **[cmp-swift-sample](samples/cmp-swift-sample)**: A sample for using Compose Multiplatform components from SwiftUI.
- **[compose-preview-lab-sample](samples/compose-preview-lab-sample)**: A sample of interactive previews using Compose Preview Lab.

# Sample links

## Wizard

### KMP Wizard (JetBrains official)
The official wizard. You can scaffold KMP projects.  
https://kmp.jetbrains.com/

### KMP Wizard (by terrakok)
An unofficial wizard by terrakok. You can also add libraries.  
https://terrakok.github.io/kmp-web-wizard/

## Libraries

### KMP Library Catalog (Kotlin official)
A catalog of libraries you can use with KMP.  
https://klibs.io/

### KMP Awesome
A curated list of libraries commonly used with KMP.  
https://github.com/terrakok/kmp-awesome

## Sample projects

### CMP samples (JetBrains official)
https://github.com/JetBrains/compose-multiplatform/tree/master/examples

### PeopleInSpace
A multi-module sample that includes Android and iOS native UI, widgets, desktop, and more.  
https://github.com/joreilly/PeopleInSpace

### Amper (Experimental)
An example using Amper (a build tool being developed as a simpler alternative to Gradle).
https://github.com/JetBrains/amper/tree/release/0.10/examples/compose-multiplatform

# For contributors

## Operating principles

- **Everyone is welcome to contribute**
  - Samples that revisit past issues with a different approach are welcome.
  - Sharing failed attempts (“tried to implement but couldn’t”) is also welcome.
- **Existing samples / generic content**
  - For content that is already published elsewhere or fairly ordinary, prefer adding it to the “Sample links” section of this README rather than duplicating it in the repo.
- **Criteria for adding to this repository**
  - We prioritize samples with few public code examples.
  - Because this repo is partly for learning, we may still add samples even if similar ones exist elsewhere (slightly different implementations are fine).
  - Samples may be removed later depending on maintenance burden.
- **Sample requests**
  - If you want a particular sample, please open an Issue in this repository.

## Notes when adding samples

- **Labels**
  - Label each sample PR so you can find implementations later (including Renovate updates). Use appropriate labels per sample.
  - GitHub Actions `labeler` supports automatic labeling. When you add a new sample, add its label and update `.github/labeler.yml`.
- **CI (GitHub Actions)**
  - Changes under `samples/` or `.github/workflows/` run `.github/workflows/ci.yml`. It runs Gradle only for changed samples; when you change the workflow definition, all samples are built.
  - The actual work is in the reusable workflow `.github/workflows/gradle-kmp-ci-reusable.yml`. It sets up JDK and Android SDK on Ubuntu and runs `./gradlew assembleDebug` at each project root (no iOS builds or tests).
  - When you add a new sample under `samples/<name>/`, update the path filters and jobs in `.github/workflows/ci.yml` (see the comments at the top of `ci.yml`).

## Maintenance
- Anyone may contribute anytime.
- There is also periodic maintenance.
