package air.balloon.tennis.app;


import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;


import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import air.balloon.tennis.app.R;
import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.dialog.MyDialog;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.Preference;

public class ParentActivity extends FragmentActivity{

    public List<Activity> activities = new ArrayList<Activity>();
    public SQLiteDatabase db;
    public String TAG;
    View actionTitleView;

    public ActionBar actionBar;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        db= MyDatabase.getInstance(this);
        activities.add(this);
        sp=getSharedPreferences(Preference.SP, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_base);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG=getLocalClassName();



    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLog.print(TAG,"onStart");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }

    public void initActionBar(){

        actionBar=getActionBar();

        if(actionBar==null)return;

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

        invalidateOptionsMenu();
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

    private ShareActionProvider mShareActionProvider;
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.parent, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_item_share);
        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();

         doShare();

        MenuItem itemCity=menu.findItem(R.id.mene_change_city);

        itemCity.setTitle(sp.getString("city",getString(R.string.city)));
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void invalidateOptionsMenu() {


        super.invalidateOptionsMenu();
    }



    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();
        MyLog.print(TAG,"menu id:"+id);
        if (id == R.id.action_settings) {
            return true;
        }


        if(id==android.R.id.home){
            this.finish();
        }

        if(id==R.id.mene_change_city){
            new MyDialog(this).showChangeCityDialog();
        }



        return super.onOptionsItemSelected(item);
    }

    // Call to update the share intent
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void doShare() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Whatever message you want to share");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"title");

      //  startActivity(shareIntent);

        MyLog.print(TAG,"setShareIntent ...");
        if (mShareActionProvider != null) {
            MyLog.print(TAG,"setShareIntent success!");
            mShareActionProvider.setShareIntent(shareIntent);

        }
    }

}
