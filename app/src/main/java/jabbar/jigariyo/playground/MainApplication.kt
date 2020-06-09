package jabbar.jigariyo.playground

import android.app.Application
import jabbar.jigariyo.playground.sdk.Configure
import jabbar.jigariyo.playground.sdk.Playground

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Configure.initSdk(this)

        Playground.setPlaygroundDialogBlocker {
            // Don't block. Allow to play
            return@setPlaygroundDialogBlocker false
        }
    }
}