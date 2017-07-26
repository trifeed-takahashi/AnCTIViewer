package jp.co.trifeed.anctiviewer;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Timer;

public class CTIPollingService extends Service {

    static final String TAG="CTIPollingService";
    private Timer mTimer = null;
    Handler mHandler = new Handler();
    PollerTask mPollerTask = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    public CTIPollingService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "onStartCommand");

        // タイマーの設定 1秒毎にループ
        mTimer = new Timer(true);
        if(mPollerTask == null) {
            mPollerTask = new PollerTask();
        }
        mTimer.scheduleAtFixedRate( mPollerTask, 0, 1000);

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        // タイマー停止
        if( mTimer != null ){
            mTimer.cancel();
            mTimer = null;
        }
        super.onDestroy();
    }


}
