package jabbar.jigariyo.playground.sdk

import android.util.Log
import android.widget.Toast
import androidx.annotation.Keep

typealias PlaygroundDialogBlocker = () -> Boolean

@Keep
object Playground {

    private const val LOG_TAG = "Playground"

    @JvmStatic
    fun setPlaygroundDialogBlocker(blocker: PlaygroundDialogBlocker) {
        if (Configure.context == null) {
            Log.e(LOG_TAG, "Did you call configure yet ?")
            return
        }
        PlaygroundInternal.playgroundDialogBlocker = blocker
    }

    fun play() {
        if (validateInit()) {
            PlaygroundInternal.playgroundDialogBlocker?.let {
                if (it.invoke()) {
                    Log.e(LOG_TAG, "App has blocked SDK from playing")
                } else {
                    // allowed to play by app
                    showToast()
                }
            } ?: showToast()
        }
    }

    private fun showToast() {
        Toast.makeText(Configure.context, "Playing", Toast.LENGTH_SHORT).show()
    }

    private fun validateInit(): Boolean {
        return (Configure.context != null).also {
            if (!it) {
                Log.e("Playground", "Did you call configure yet ?")
            }
        }
    }
}