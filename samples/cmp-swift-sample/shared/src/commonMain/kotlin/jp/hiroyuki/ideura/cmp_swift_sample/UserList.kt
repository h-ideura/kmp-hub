package jp.hiroyuki.ideura.cmp_swift_sample

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserList(
    users: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(users) { user ->
            Text(text = user, modifier = Modifier.padding(16.dp))
            HorizontalDivider()
        }
    }
}
