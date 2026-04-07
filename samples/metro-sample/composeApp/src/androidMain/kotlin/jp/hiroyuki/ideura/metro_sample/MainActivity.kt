package jp.hiroyuki.ideura.metro_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jp.hiroyuki.ideura.metro_sample.di.AppGraph
import dev.zacsweers.metro.createGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val graph = createGraph<AppGraph>()

        setContent {
            App(graph = graph)
        }
    }
}
