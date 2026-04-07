package jp.hiroyuki.ideura.metro_sample

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import jp.hiroyuki.ideura.metro_sample.di.AppGraph
import dev.zacsweers.metro.createGraph

fun MainViewController() = ComposeUIViewController {
    val graph = remember { createGraph<AppGraph>() }
    App(graph = graph)
}
