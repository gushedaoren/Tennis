package air.balloon.tennis.app;

import android.os.Bundle;


public class CourtActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        setTitleOnActionBar(getString(R.string.title_activity_court));





    }



}
