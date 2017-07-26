package jp.co.trifeed.anctiviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartService(View view){
        switch (view.getId()) {
            case R.id.btnStart:
                Toast.makeText(MainActivity.this, "サービスをスタートします", Toast.LENGTH_LONG).show();
                startService(new Intent(MainActivity.this, CTIPollingService.class));
                break;
        }
    }

    public void onStopService(View view){
        switch (view.getId()) {
            case R.id.btnStop:
                Toast.makeText(MainActivity.this, "サービスを停止します", Toast.LENGTH_LONG).show();
                stopService(new Intent(MainActivity.this, CTIPollingService.class));
                break;
        }
    }
}
