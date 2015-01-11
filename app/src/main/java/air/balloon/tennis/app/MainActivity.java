package air.balloon.tennis.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.common.Log;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.DevReply;
import com.umeng.fb.model.Reply;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import air.balloon.tennis.notify.FeedbackNotification;
import umeng.fb.ConversationActivity;


public class MainActivity extends ParentActivity implements View.OnClickListener{


    FrameLayout btnLeft1,btnLeft2,btnLeft3,btnRight1,btnRight2,btnRight3;


    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        printChanel();


        findViews();

        initUmeng();

    }

    private long exitTime = 0;

//    @Override
//    public void onBackPressed() {
//
//        new MyDialog(this).showExitDialg(activities);
//    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                saveLoginState(false);
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initUmeng() {
        FeedbackAgent agent = new FeedbackAgent(this);



        agent.getDefaultConversation().sync(new Conversation.SyncListener() {
            @Override
            public void onReceiveDevReply(List<DevReply> devReplies) {

                if(devReplies==null)return;

                Log.LOG=true;

                Log.a(TAG,"onReceiveDevReply");
                Log.a(TAG,"reply size:"+devReplies.size());


               if(devReplies.size()>=1){

                   String result=devReplies.get(0).toJson().toString();
//                   Log.a(TAG,result);

                   try {
                       JSONObject json=new JSONObject(result);
                       String content=json.optString("content");


                       Intent intent;
                       intent = new Intent(getApplicationContext(), ConversationActivity.class);
                       startActivity(intent);



                   } catch (JSONException e) {
                       e.printStackTrace();
                   }


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

        btnLeft1= (FrameLayout) findViewById(R.id.btn_left1);

        btnLeft2=(FrameLayout) findViewById(R.id.btn_left2);

        btnLeft3=(FrameLayout) findViewById(R.id.btn_left3);

        btnRight1=(FrameLayout) findViewById(R.id.btn_right1);

        btnRight2=(FrameLayout) findViewById(R.id.btn_right2);

        btnRight3=(FrameLayout) findViewById(R.id.btn_right3);


        imgLogo= (ImageView) findViewById(R.id.img_logo);
        btnLeft1.setOnClickListener(this);
        btnLeft2.setOnClickListener(this);
        btnLeft3.setOnClickListener(this);


        btnRight1.setOnClickListener(this);
        btnRight2.setOnClickListener(this);
        btnRight3.setOnClickListener(this);
        imgLogo.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_left1:

                intent.setClass(getApplicationContext(),EventListActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_left2:
                intent.setClass(getApplicationContext(),CourtListActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_left3:
                intent.setClass(getApplicationContext(),FriendListActivity.class);
                startActivity(intent);


                break;
            case R.id.btn_right1:

                intent.setClass(getApplicationContext(),EventPromotionalAcivity.class);
                startActivity(intent);
                break;
            case R.id.btn_right2:
                boolean logined=getLoginState();
                if(logined){
                    intent.setClass(getApplicationContext(),PersonalPageActivity.class);
                    startActivity(intent);
                }else{
                    intent.setClass(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }



                break;
            case R.id.btn_right3:
                intent.setClass(getApplicationContext(),MoreActivity.class);
                startActivity(intent);

                break;

            case R.id.img_logo:

                Uri uri= Uri.parse("http://nixuchen.com");   //指定网址
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uri);
                startActivity(intent);

                break;
            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
