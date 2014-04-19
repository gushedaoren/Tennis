package air.balloon.tennis.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import air.balloon.tennis.parent.BaseActivity;


public class MoreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        setTitleOnActionBar(getString(R.string.more));
    }




}
