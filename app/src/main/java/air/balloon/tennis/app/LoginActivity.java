package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


/**
 * A login screen that offers login via email/password and via Google+ sign in.
 * <p/>
 * ************ IMPORTANT SETUP NOTES: ************
 * In order for Google+ sign in to work with your app, you must first go to:
 * https://developers.google.com/+/mobile/android/getting-started#step_1_enable_the_google_api
 * and follow the steps in "Step 1" to create an OAuth 2.0 client for your package.
 */
public class LoginActivity extends ParentActivity implements OnClickListener{
    LinearLayout btnSignup;



    EditText et_user,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitleOnActionBar(getString(R.string.login));



        findViews();


    }


    private void findViews() {


        et_user= (EditText) findViewById(R.id.user);
        et_password= (EditText) findViewById(R.id.password);

        btnSignup= (LinearLayout) findViewById(R.id.signup);
        btnSignup.setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.signup:
                intent.setClass(getApplicationContext(),RegisterActivity.class
                );
                startActivity(intent);

                break;

            case R.id.btn_login:

                doLogin();
                break;

            default:
                break;

        }
    }

    private void doLogin() {


        MyLog.print(TAG,"doLogin");
        String user=et_user.getText().toString();
        String password=et_password.getText().toString();




        AsyncHttpClient client=new AsyncHttpClient();
        String url= API.LOGIN;
        RequestParams params=new RequestParams();
        params.put("username",user);
        params.put("password",password);


        client.get(this, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);

                String result=new String(responseBody);

                try {
                    JSONObject json=new JSONObject(result);
                    String code=json.optString("statusCode");
                    String message=json.optString("message");
                    if(code.equals("0")){

                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        saveLoginState(true);
                        finish();

                    }else{
                        Toast.makeText(LoginActivity.this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    private void saveLoginState(boolean hasLogin){

        /*
           已经登录true，未登录false；
         */


        sp.edit().putBoolean("loginState",hasLogin
        ).commit();

    };
}


