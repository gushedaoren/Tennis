package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.location.BDLocationTask;
import air.balloon.tennis.service.MainService;


public class SplashActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MyDatabase.getInstance(this);
        startMainService();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,CourtListActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,R.anim.zoom_out);
            }
        },3000);
    }

    private void startMainService() {
        Intent intent=new Intent(this, MainService.class);
        startService(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
