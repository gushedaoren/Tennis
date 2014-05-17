package air.balloon.tennis.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import air.balloon.tennis.model.TennisUser;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


public class FriendActivity extends ParentActivity {

    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;

    long id;

    TennisUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        setTitleOnActionBar(getString(R.string.title_activity_friend));

        init();


    }

    private void init() {
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        txt4= (TextView) findViewById(R.id.txt4);
        txt5= (TextView) findViewById(R.id.txt5);
        txt6= (TextView) findViewById(R.id.txt6);
        txt7= (TextView) findViewById(R.id.txt7);

        id=getIntent().getLongExtra("id",0);

        if(id!=0){
            initData(id);
        }

    }

    private void initData(long id) {

        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        String url= API.getFriend(id);

        MyLog.print(TAG,url);
        asyncHttpClient.get(url,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);


                String result=new String(responseBody);
                MyLog.print(TAG,result);

                Gson gson=new Gson();
                user=gson.fromJson(result,TennisUser.class);

                txt1.setText(user.getName());
                txt2.setText(user.getRoles());
                txt3.setText(user.getGender_BaseEnum_Model().getEnumDesc());
                txt5.setText(user.getAccountLevel());
                txt6.setText(user.getPhone());
                txt7.setText(user.getAddress());
            }
        });

    }


}
