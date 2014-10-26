package air.balloon.tennis.app;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import air.balloon.tennis.model.Court;
import air.balloon.tennis.model.CourtDTO;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;

/**
 * Created by oliver on 5/17/14.
 */
public class CourtActivity extends ParentActivity {

    Court court;
    TextView txt1,txt2,txt3,txt4,txt5,txt6;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);
        setTitleOnActionBar(getString(R.string.title_activity_court));
        
        
        init();
    }

    private void init() {
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        txt4= (TextView) findViewById(R.id.txt4);
        txt5= (TextView) findViewById(R.id.txt5);
        txt6= (TextView) findViewById(R.id.txt6);
        id=getIntent().getLongExtra("id",0);

        if(id!=0){
            initData(id);
        }

    }

    private void initData(long id) {

        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        String url= API.getCourt(id);

        MyLog.print(TAG, url);

        asyncHttpClient.get(url,new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);


                String result=new String(responseBody);
                MyLog.print(TAG,result);

                Gson gson=new Gson();

                CourtDTO courtDTO=gson.fromJson(result,CourtDTO.class);
                court=courtDTO.getCourt_Court_Model();

                txt1.setText(court.getTitle());
                txt2.setText(court.getDescription());
                txt3.setText(court.getAddress());
                txt4.setText(court.getPhone());
                txt5.setText(court.getCourt_number());



            }
        });
    }
}
