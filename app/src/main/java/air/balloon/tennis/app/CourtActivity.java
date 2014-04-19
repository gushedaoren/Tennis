package air.balloon.tennis.app;

import android.app.ActionBar;
import android.app.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import air.balloon.tennis.parent.BaseActivity;


public class CourtActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        setTitleOnActionBar(getString(R.string.title_activity_court));





    }



}
