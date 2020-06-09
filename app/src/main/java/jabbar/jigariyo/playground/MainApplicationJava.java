package jabbar.jigariyo.playground;

import android.app.Application;

import jabbar.jigariyo.playground.sdk.Configure;
import jabbar.jigariyo.playground.sdk.Playground;

public class MainApplicationJava extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Configure.initSdk(this);

        Playground.setPlaygroundDialogBlocker(() -> false);
    }
}
