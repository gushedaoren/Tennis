package air.balloon.tennis.app;

import android.os.Bundle;


public class CourtListActivity extends MListViewActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_list);


        setTitleOnActionBar(getString(R.string.title_activity_court_list));







    }



}
