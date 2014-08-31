package air.balloon.tennis.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import air.balloon.tennis.location.BDLocationTask;
import air.balloon.tennis.utils.MyLog;

/**
 * Created by oliver on 5/22/14.
 */
public class MainService extends Service{
    BDLocationTask locationTask;
    String TAG="MainService";
    @Override
    public void onCreate() {
        super.onCreate();

        MyLog.print(TAG,"mainService onCreate");
        locationTask= new BDLocationTask(this);
        locationTask.saveLocation();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationTask.stop();
    }
}
