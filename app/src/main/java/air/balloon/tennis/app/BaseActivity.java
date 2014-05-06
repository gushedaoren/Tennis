package air.balloon.tennis.app;


import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.umeng.analytics.MobclickAgent;

import air.balloon.tennis.app.R;
import air.balloon.tennis.utils.MyLog;

public class BaseActivity extends Activity{

    public SQLiteDatabase db;
    public String TAG;
    View actionTitleView;

    public ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG=getLocalClassName();
        initActionBar();


    }


    private void initActionBar(){

        actionBar=getActionBar();



        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        actionTitleView= LayoutInflater.from(this
        ).inflate(R.layout.title_bar,null);

        ActionBar.LayoutParams params=new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.MATCH_PARENT);

        params.gravity= Gravity.CENTER_HORIZONTAL;
        actionBar.setCustomView(actionTitleView,params);

        actionBar.setTitle(getString(R.string.back));


    }


    public void setTitleOnActionBar(String title){

        TextView textView= (TextView) actionTitleView.findViewById(R.id.action_bar_title
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

   public void titleBarAction(){
       LinearLayout btnBack= (LinearLayout) findViewById(R.id.btn_back);
       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
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


            com.umeng.common.Log.LOG=true;

            com.umeng.common.Log.a(TAG, "CHANNEL:"+msg);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }


        if(id==android.R.id.home){
            this.finish();
        }





        return super.onOptionsItemSelected(item);
    }

}
