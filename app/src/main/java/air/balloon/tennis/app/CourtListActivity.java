package air.balloon.tennis.app;

import android.app.Fragment;
import android.os.Bundle;

import air.balloon.tennis.city.ChangeCityListener;


public class CourtListActivity extends MListViewActivity {

    public ChangeCityListener changeCityListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_list);


        setTitleOnActionBar(getString(R.string.title_activity_court_list));







    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        try{
            changeCityListener=(ChangeCityListener)fragment;


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
