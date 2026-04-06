package jp.hiroyuki.ideura.cmp_swift_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                // Androidプラットフォーム側で状態を保持 (mutableStateListOf)
                val users = remember { mutableStateListOf("Android User 1", "Android User 2", "Android User 3") }
                var nextUserNum by remember { mutableStateOf(4) }

                MainScreen(
                    users = users,
                    onAddUser = {
                        users.add("Android User $nextUserNum")
                        nextUserNum++
                    },
                    onDeleteUser = { user ->
                        users.remove(user)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    users: List<String>,
    onAddUser: () -> Unit,
    onDeleteUser: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("User List (Android Native)") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddUser) {
                Icon(Icons.Default.Add, contentDescription = "Add User")
            }
        }
    ) { innerPadding ->
        UserList(
            users = users,
            onDeleteUser = onDeleteUser,
            modifier = Modifier.padding(innerPadding),
        )
    }
}
