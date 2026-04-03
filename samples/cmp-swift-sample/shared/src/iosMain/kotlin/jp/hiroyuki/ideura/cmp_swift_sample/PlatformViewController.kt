package jp.hiroyuki.ideura.cmp_swift_sample

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun UserListViewController(users: List<String>): UIViewController = ComposeUIViewController {
    MaterialTheme {
        UserList(users)
    }
}