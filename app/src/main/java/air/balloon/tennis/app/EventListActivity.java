package air.balloon.tennis.app;

import android.os.Bundle;


public class EventListActivity extends MListViewActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        setTitleOnActionBar(getString(R.string.title_activity_event));

    }



}
