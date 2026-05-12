package com.example.collecting.data.androidApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.collecting.data.uicomponents.DesignSystemComponentData
import com.example.collecting.data.uicomponents.gallery.GalleryScreen
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.createGraph

class AppActivity : ComponentActivity() {
    private val appGraph: AppGraph by lazy { createGraph() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface {
                    GalleryScreen(
                        components = appGraph.components,
                    )
                }
            }
        }
    }
}

@DependencyGraph(scope = AppScope::class)
internal interface AppGraph {
    val components: Set<DesignSystemComponentData>
}
