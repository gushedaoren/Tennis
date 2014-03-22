package air.balloon.tennis.parent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import air.balloon.tennis.app.R;

public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);




    }


    @Override
    protected void onResume() {
        super.onResume();

     //   MobclickAgent.onPageStart(this.getClass().getSimpleName()); //统计页面
        MobclickAgent.onResume(this);          //统计时长
    }


    @Override
    protected void onPause() {
        super.onPause();


    //    MobclickAgent.onPageEnd(this.getClass().getSimpleName()); // 保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息
        MobclickAgent.onPause(this);
    }
}
