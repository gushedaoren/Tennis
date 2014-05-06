package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import umeng.fb.ConversationActivity;


public class MoreActivity extends BaseActivity implements View.OnClickListener{


    LinearLayout btnFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        setTitleOnActionBar(getString(R.string.more));
        init();


    }


    private void init() {
        btnFeedBack= (LinearLayout) findViewById(R.id.btn_feedback);

        btnFeedBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_feedback:

//                FeedbackAgent agent = new FeedbackAgent(MoreActivity.this);
//
//                agent.startFeedbackActivity();

                intent.setClass(MoreActivity.this, ConversationActivity.class
                );
                startActivity(intent);

                break;

        }

    }
}
