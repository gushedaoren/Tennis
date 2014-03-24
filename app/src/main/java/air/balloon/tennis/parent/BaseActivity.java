package air.balloon.tennis.parent;


import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.util.Log;


import com.umeng.analytics.MobclickAgent;

import air.balloon.tennis.app.R;

public class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);




    }


    @Override
    protected void onResume() {
        super.onResume();
      //  TALogger.i(this,this.getCallingActivity()+" on resume");

        printChanel();;
        MobclickAgent.onPageStart(String.valueOf(this.getComponentName())); //统计页面
        MobclickAgent.onResume(this);    //统计时长



    }


    @Override
    protected void onPause() {
        super.onPause();


       MobclickAgent.onPageEnd(String.valueOf(this.getComponentName())); // 保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息
        MobclickAgent.onPause(this);
    }



    public void printChanel(){


        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);

            String msg=appInfo.metaData.getString("UMENG_CHANNEL");
            Log.i(getLocalClassName(),"CHANNEL:"+msg);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
