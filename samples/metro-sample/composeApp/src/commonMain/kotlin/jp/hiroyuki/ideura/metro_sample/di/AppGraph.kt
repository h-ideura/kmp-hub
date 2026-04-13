package jp.hiroyuki.ideura.metro_sample.di

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metrox.viewmodel.ViewModelGraph

@DependencyGraph(AppScope::class)
interface AppGraph: ViewModelGraph
