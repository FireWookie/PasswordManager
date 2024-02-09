import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
        var appDelegate: AppDelegate
    
    var body: some Scene {
        WindowGroup {
            ComposeView(appDelegate.root).ignoresSafeArea(.all)
        }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    private var component: RootComponent
    
    init(_ component: RootComponent) {
        self.component = component
    }

    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController(component: component)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
