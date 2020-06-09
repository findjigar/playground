package jabbar.jigariyo.playground.sdk

import android.content.Context
import androidx.annotation.Keep

@Keep
object Configure {

    internal var context: Context? = null

    /**
     * @param context ApplicationContext
     */
    @JvmStatic
    fun initSdk(context: Context) {
        this.context = context.applicationContext
    }
}