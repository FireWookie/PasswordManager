//
//  AppDelegate.swift
//  iosApp
//
//  Created by Никита on 09.02.2024.
//

import ComposeApp
import UIKit


class AppDelegate: NSObject, UIApplicationDelegate {
    let root: RootComponent = DefaultRootComponent(componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle()))
}
