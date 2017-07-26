package jp.co.trifeed.anctiviewer;

import android.util.Log;

import java.util.TimerTask;

/**
 * Created by takahashimasatsugu on 2017/07/25.
 */

public class PollerTask extends TimerTask {

    static final String TAG="PollerTask";

    @Override
    public void run() {
        Log.d(TAG, "Hello!");
    }
}
