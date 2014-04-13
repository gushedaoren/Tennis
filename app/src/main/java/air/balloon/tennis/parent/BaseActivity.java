package air.balloon.tennis.parent;


import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.umeng.analytics.MobclickAgent;

import air.balloon.tennis.app.R;
import air.balloon.tennis.utils.MyLog;

public class BaseActivity extends Activity{

    public SQLiteDatabase db;
    public String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        TAG=getLocalClassName();


    }


    public void setTitleOnTopBar(String title){

        TextView textView= (TextView) findViewById(R.id.title_bar_title
        );

        textView.setText(title);

    }

    @Override
    protected void onResume() {
        super.onResume();
      //  TALogger.i(this,this.getCallingActivity()+" on resume");


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
           // Log.i(getLocalClassName(),"CHANNEL:"+msg);

            MyLog.print(getLocalClassName(),"CHANNEL:"+msg);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
