import SwiftUI
import Shared

struct UserListView: UIViewControllerRepresentable {
    let users: [String]

    func makeUIViewController(context: Context) -> UIViewController {
        PlatformViewControllerKt.UserListViewController(users: users)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    let sampleUsers = ["iOS User A", "iOS User B", "iOS User C"]

    var body: some View {
        NavigationView {
            VStack {
                UserListView(users: sampleUsers)
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
            }
            .navigationTitle("User List (SwiftUI)")
            .edgesIgnoringSafeArea(.bottom)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
