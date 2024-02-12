package ru.pet.passmanager.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.pet.passmanager.di.KoinInjector
import ru.pet.passmanager.di.platformModule

class PassManagerApp : Application() {
    companion object {
        lateinit var INSTANCE: PassManagerApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        KoinInjector.koinApp.androidContext(this)
        KoinInjector.loadModules(listOf(platformModule))
        activityInject()
    }

    private fun activityInject() {
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

            override fun onActivityResumed(activity: Activity) {
                KoinInjector.koin.loadModules(listOf(module {
                    single { activity }
                }))
            }

            override fun onActivityPaused(activity: Activity) {
                KoinInjector.koin.unloadModules(listOf(module {
                    single { activity }
                }))
            }


            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityDestroyed(activity: Activity) {}


        })
    }
}