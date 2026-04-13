package jp.hiroyuki.ideura.metro_sample.feature.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import dev.zacsweers.metrox.viewmodel.metroViewModel
import jp.hiroyuki.ideura.metro_sample.core.model.UserDetail

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = metroViewModel(),
    login: String,
    onBack: () -> Unit
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    LaunchedEffect(login) {
        viewModel.loadUser(login)
    }

    DetailContent(
        login = login,
        user = user,
        isLoading = isLoading,
        onBack = onBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
    login: String,
    user: UserDetail?,
    isLoading: Boolean,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(login) },
                navigationIcon = {
                    Button(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            if (isLoading && user == null) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                user?.let { u ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = u.avatarUrl,
                            contentDescription = null,
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = u.name ?: u.login, style = MaterialTheme.typography.headlineMedium)
                        u.bio?.let {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = it)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text("Followers: ${u.followers}")
                            Text("Following: ${u.following}")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    MaterialTheme {
        DetailContent(
            login = "mojombo",
            user = UserDetail(
                id = 1,
                login = "mojombo",
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                name = "Tom Preston-Werner",
                company = "@chatterbugapp, @redwoodjs, @unosecur",
                location = "San Francisco",
                bio = "I code things.",
                followers = 23784,
                following = 11
            ),
            isLoading = false,
            onBack = {}
        )
    }
}
