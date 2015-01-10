package air.balloon.tennis.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;
import air.balloon.tennis.value.Config;


public class EventPromotionalAcivity extends ParentActivity {

    EditText edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_promotional_acivity);



        edit1= (EditText) findViewById(R.id.edit1);
        edit2= (EditText) findViewById(R.id.edit2);
        edit3= (EditText) findViewById(R.id.edit3);
        edit4= (EditText) findViewById(R.id.edit4);
        edit5= (EditText) findViewById(R.id.edit5);
        edit6= (EditText) findViewById(R.id.edit6);
        edit7= (EditText) findViewById(R.id.edit7);
        edit8= (EditText) findViewById(R.id.edit8);

        btn= (Button) findViewById(R.id.btn_ok);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendData();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendData() throws UnsupportedEncodingException {


        AsyncHttpClient client = new AsyncHttpClient(Config.HTTP_PORT);
        String level,phone;



        RequestParams params=new RequestParams();
        params.put("title", edit1.getText().toString());
        params.put("description",edit2.getText().toString());
        params.put("address",edit3.getText().toString());
        params.put("level",edit4.getText().toString() );
        params.put("phone",edit5.getText().toString());
        params.put("time",edit6.getText().toString());
        params.put("fee",edit7.getText().toString());
        params.put("remark",edit8.getText().toString());

        client.get( API.POST_EVENT,params,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);


                String result=new String(responseBody);
                MyLog.print(TAG, result);

                try {
                    JSONObject json=new JSONObject(result);
                    String code=json.optString("statusCode");
                    String message=json.optString("message");
                    if(code.equals("0")){

                        Toast.makeText(EventPromotionalAcivity.this, "发布成功", Toast.LENGTH_SHORT).show();

                        finish();

                    }else{
                        Toast.makeText(EventPromotionalAcivity.this,"系统维护中，请稍后再试",Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                super.onFailure(statusCode, headers, responseBody, error);
                MyLog.print(TAG, new String(responseBody));


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_promotional_acivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
