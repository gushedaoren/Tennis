package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import umeng.fb.ConversationActivity;


public class MoreActivity extends ParentActivity implements View.OnClickListener{


    LinearLayout btnMore1,btnMore2,btnMore4,btnMore5,btnMore6,btnMore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        setTitleOnActionBar(getString(R.string.more));
        init();


    }


    private void init() {
        btnMore6= (LinearLayout) findViewById(R.id.btn_more6);
        btnMore5= (LinearLayout) findViewById(R.id.btn_more5);
        btnMore4= (LinearLayout) findViewById(R.id.btn_more4);
        btnMore3= (LinearLayout) findViewById(R.id.btn_more3);
        btnMore2= (LinearLayout) findViewById(R.id.btn_more2);
        btnMore1= (LinearLayout) findViewById(R.id.btn_more1);

        btnMore6.setOnClickListener(this);
        btnMore5.setOnClickListener(this);
        btnMore4.setOnClickListener(this);
        btnMore3.setOnClickListener(this);
        btnMore2.setOnClickListener(this);
        btnMore1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_more6:

//                FeedbackAgent agent = new FeedbackAgent(MoreActivity.this);
//
//                agent.startFeedbackActivity();

                intent.setClass(MoreActivity.this, ConversationActivity.class
                );
                startActivity(intent);

                break;

            case R.id.btn_more5:

                intent.setClass(MoreActivity.this,RegisterActivity.class);
                startActivity(intent);
             break;

            case R.id.btn_more4:

                intent.setClass(MoreActivity.this,LoginActivity.class);
                startActivity(intent);
                break;


            case R.id.btn_more1:
                intent.setClass(MoreActivity.this,AboutActivity.class);
                startActivity(intent);
                break;

        }

    }
}
