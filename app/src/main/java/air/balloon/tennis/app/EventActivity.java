package air.balloon.tennis.app;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import air.balloon.tennis.model.Event;
import air.balloon.tennis.model.EventDTO;
import air.balloon.tennis.model.EventListDTO;
import air.balloon.tennis.model.TennisUser;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;

/**
 * Created by oliver on 5/17/14.
 */
public class EventActivity extends ParentActivity {

    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;

    long id;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setTitleOnActionBar(getString(R.string.title_activity_event));
        init();
    }

    private void initData(long id) {

        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        String url= API.getEvent(id);

        MyLog.print(TAG, url);
        asyncHttpClient.get(url,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);


                String result=new String(responseBody);
                MyLog.print(TAG,result);

                Gson gson=new Gson();

                EventDTO eventDTO=gson.fromJson(result,EventDTO.class);
                event=eventDTO.getEvent_Event_Model();

                txt1.setText(event.getTitle());
                txt2.setText(event.getDescrition());
                txt3.setText(event.getAddress());
//                txt4.setText(event.getRequire());
//                txt5.setText(event.getPhone());
//                txt6.setText(event.getEventTime());
            }
        });

    }


    private void init() {

        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        txt4= (TextView) findViewById(R.id.txt4);
        txt5= (TextView) findViewById(R.id.txt5);
        txt6= (TextView) findViewById(R.id.txt6);
        txt7= (TextView) findViewById(R.id.txt7);
        txt8= (TextView) findViewById(R.id.txt8);


        id=getIntent().getLongExtra("id",0);

        MyLog.print(TAG,"id:"+id);

        if(id!=0){
            initData(id);
        }
    }
}
