import SwiftUI
import Shared

struct UserListView: UIViewControllerRepresentable {
    let users: [String]
    let onDeleteUser: (String) -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        let wrapper = PlatformViewControllerKt.createUserListControllerWrapper(
            users: users,
            onDeleteUser: onDeleteUser
        )
        context.coordinator.wrapper = wrapper
        return wrapper.viewController
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // SwiftUI の @State が変わるたびに、ラッパー経由で CMP UI の状態を同期させる
        context.coordinator.wrapper?.updateUsers(newUsers: users)
    }

    func makeCoordinator() -> Coordinator {
        Coordinator()
    }

    class Coordinator {
        var wrapper: UserListControllerWrapper?
    }
}

struct ContentView: View {
    // iOSネイティブの状態管理 (@State)
    @State private var users = ["iOS User A", "iOS User B", "iOS User C"]
    @State private var nextUserChar = "D"

    var body: some View {
        NavigationView {
            VStack {
                UserListView(users: users) { deletedUser in
                    if let index = users.firstIndex(of: deletedUser) {
                        users.remove(at: index)
                    }
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            }
            .navigationTitle("User List (SwiftUI)")
            .navigationBarItems(trailing: Button(action: {
                users.append("iOS User \(nextUserChar)")
                if let charCode = nextUserChar.unicodeScalars.first?.value {
                    if let newCharCode = UnicodeScalar(charCode + 1) {
                        nextUserChar = String(newCharCode)
                    }
                }
            }) {
                Image(systemName: "plus")
            })
            .edgesIgnoringSafeArea(.bottom)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
