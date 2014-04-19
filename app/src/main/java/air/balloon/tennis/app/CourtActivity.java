package air.balloon.tennis.app;

import android.app.ActionBar;
import android.app.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class CourtActivity extends ActionBarActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        initActionBar();


    }


    private void initActionBar(){
        actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setDisplayShowCustomEnabled(true);

        View titleView= LayoutInflater.from(this
        ).inflate(R.layout.title_bar,null);
        actionBar.setCustomView(titleView);
        ActionBar.LayoutParams params=new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT);

        actionBar.setCustomView(titleView,params);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);


    }




    public void doShare() {
        // populate the share intent with data
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "This is a message for you");
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.court, menu);
        return true;
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

        if(id==R.id.action_share){
            doShare();
        }


        return super.onOptionsItemSelected(item);
    }

}
