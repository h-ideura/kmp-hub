package jp.hiroyuki.ideura.cmp_swift_sample

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

// iOSネイティブの状態 (SwiftUI @State) を受け取り、CMP UI に反映させるためのブリッジラッパー
class UserListControllerWrapper(
    initialUsers: List<String>,
    private val onDeleteUser: (String) -> Unit
) {
    // SwiftUI から渡されるリストを Compose が検知できるようにするための Compose State
    private val _users = mutableStateOf(initialUsers)

    val viewController: UIViewController = ComposeUIViewController {
        MaterialTheme {
            UserList(
                users = _users.value, // Compose State を読み取ることで、更新時に再描画される
                onDeleteUser = onDeleteUser
            )
        }
    }

    // SwiftUI の updateUIViewController から呼び出す
    fun updateUsers(newUsers: List<String>) {
        _users.value = newUsers
    }
}

fun createUserListControllerWrapper(
    users: List<String>,
    onDeleteUser: (String) -> Unit
): UserListControllerWrapper = UserListControllerWrapper(users, onDeleteUser)
