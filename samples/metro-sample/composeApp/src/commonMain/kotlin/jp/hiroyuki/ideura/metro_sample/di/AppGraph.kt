package jp.hiroyuki.ideura.metro_sample.di

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.AppScope
import jp.hiroyuki.ideura.metro_sample.feature.list.ListViewModel
import jp.hiroyuki.ideura.metro_sample.feature.detail.DetailViewModel

@DependencyGraph(AppScope::class)
interface AppGraph {
    val listViewModel: ListViewModel
    val detailViewModel: DetailViewModel
}
