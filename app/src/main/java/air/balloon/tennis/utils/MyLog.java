package air.balloon.tennis.utils;

import android.util.Log;

import air.balloon.tennis.value.Config;

/**
 * Created by oliver on 3/30/14.
 */
public class MyLog {

    public static void print(String TAG,String content){

        if(Config.showLog)
        Log.i(TAG,content);
    }

}
