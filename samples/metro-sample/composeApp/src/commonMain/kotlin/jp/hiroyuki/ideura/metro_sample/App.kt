package jp.hiroyuki.ideura.metro_sample

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.compose.serialization.serializers.SnapshotStateListSerializer
import jp.hiroyuki.ideura.metro_sample.feature.list.ListScreen
import jp.hiroyuki.ideura.metro_sample.feature.detail.DetailScreen
import jp.hiroyuki.ideura.metro_sample.di.AppGraph
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey

@Serializable
object List : Route

@Serializable
data class Detail(val login: String) : Route



@Composable
fun App(graph: AppGraph) {
    MaterialTheme {
        val backStack: MutableList<Route> =
            rememberSerializable(serializer = SnapshotStateListSerializer()) {
                mutableStateListOf(List)
            }

        val entryProvider = entryProvider<NavKey> {
            entry<List> {
                ListScreen(
                    viewModel = viewModel { graph.listViewModel },
                    onUserClick = { login ->
                        backStack.add(Detail(login))
                    }
                )
            }
            entry<Detail> { detail ->
                DetailScreen(
                    viewModel = viewModel { graph.detailViewModel },
                    login = detail.login,
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }

        NavDisplay(
            backStack = backStack,
            entryProvider = entryProvider
        )
    }
}
