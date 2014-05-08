package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.umeng.common.Log;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.DevReply;
import com.umeng.fb.model.Reply;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.notify.FeedbackNotification;
import air.balloon.tennis.utils.MyLog;
import umeng.fb.ConversationActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener{


    LinearLayout btnLeft1,btnLeft2,btnLeft3,btnRight1,btnRight2,btnRight3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= MyDatabase.getInstance(this);
        printChanel();
        actionBar.hide();

        findViews();

        initUmeng();

    }

    private void initUmeng() {
        FeedbackAgent agent = new FeedbackAgent(this);



        agent.getDefaultConversation().sync(new Conversation.SyncListener() {
            @Override
            public void onReceiveDevReply(List<DevReply> devReplies) {

                Log.LOG=true;

                Log.a(TAG,"onReceiveDevReply");
                Log.a(TAG,"reply size:"+devReplies.size());


               if(devReplies.size()>=1){

////                   String result=devReplies.get(0).toJson().toString();
////                   Log.a(TAG,result);
//
//                   try {
//                       JSONObject json=new JSONObject(result);
//                       String content=json.optString("content");
//
//
////                       Intent intent;
////                       intent = new Intent(getApplicationContext(), ConversationActivity.class);
////                       startActivity(intent);
//
//
//
//                   } catch (JSONException e) {
//                       e.printStackTrace();
//                   }


                   new FeedbackNotification(MainActivity.this
                   ).showNofity();


               }


            }

            @Override
            public void onSendUserReply(List<Reply> replies) {

            }
        });
    }


    private void findViews(){

        btnLeft1= (LinearLayout) findViewById(R.id.btn_left1);

        btnLeft2=(LinearLayout) findViewById(R.id.btn_left2);

        btnLeft3=(LinearLayout) findViewById(R.id.btn_left3);

        btnRight1=(LinearLayout) findViewById(R.id.btn_right1);

        btnRight2=(LinearLayout) findViewById(R.id.btn_right2);

        btnRight3=(LinearLayout) findViewById(R.id.btn_right3);


        btnLeft1.setOnClickListener(this);
        btnLeft2.setOnClickListener(this);
        btnLeft3.setOnClickListener(this);


        btnRight1.setOnClickListener(this);
        btnRight2.setOnClickListener(this);
        btnRight3.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_left1:

                intent.setClass(getApplicationContext(),EventActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_left2:
                intent.setClass(getApplicationContext(),CourtActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_left3:


                break;
            case R.id.btn_right1:


                break;
            case R.id.btn_right2:
                intent.setClass(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_right3:
                intent.setClass(getApplicationContext(),MoreActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
