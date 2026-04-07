package jp.hiroyuki.ideura.metro_sample

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import jp.hiroyuki.ideura.metro_sample.feature.list.ListScreen
import jp.hiroyuki.ideura.metro_sample.feature.detail.DetailScreen
import jp.hiroyuki.ideura.metro_sample.di.AppGraph
import kotlinx.serialization.Serializable

@Serializable
object List

@Serializable
data class Detail(val login: String)

@Composable
fun App(graph: AppGraph) {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = List) {
            composable<List> {
                ListScreen(
                    viewModel = viewModel { graph.listViewModel },
                    onUserClick = { login ->
                        navController.navigate(Detail(login))
                    }
                )
            }
            composable<Detail> { backStackEntry ->
                val detail: Detail = backStackEntry.toRoute()
                DetailScreen(
                    viewModel = viewModel { graph.detailViewModel },
                    login = detail.login,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
