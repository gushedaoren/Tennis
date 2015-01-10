package air.balloon.tennis.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


public class RegisterActivity extends ParentActivity implements View.OnClickListener{

    EditText editUser,editPass1,editPass2;

    Button btnSubmit;

    CheckBox checkMan,checkWoman;
    int gender=0 ; //man 0 ,woman 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitleOnActionBar(getString(R.string.register));
        findViews();
        genderAction();



    }

    private void genderAction() {
        checkMan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkWoman.setChecked(false);
                    gender=0;
                    MyLog.print(TAG,"gender:"+gender);
                }


            }
        });
        checkWoman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkMan.setChecked(false);
                    gender=1;
                    MyLog.print(TAG,"gender:"+gender);
                }


            }
        });

    }


    private void findViews() {

        editUser= (EditText) this.findViewById(R.id.edit_user);
        editPass1= (EditText) this.findViewById(R.id.edit_password1);
        editPass2= (EditText) this.findViewById(R.id.edit_password2);
        btnSubmit= (Button) findViewById(R.id.btn_submit
        );
        btnSubmit.setOnClickListener(this);
        checkMan= (CheckBox) this.findViewById(R.id.check_man);
        checkWoman= (CheckBox) findViewById(R.id.check_woman);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_submit:

                String pass1, pass2;
                pass1=editPass1.getText().toString();
                pass2=editPass1.getText().toString();
                if(pass1.equals(pass2)){
                    doSubmit();
                }else if(pass1.equals("")){
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                }


                break;
        }

    }

    private void doSubmit() {
        AsyncHttpClient client=new AsyncHttpClient();
        String url= API.REGISTER;
        RequestParams params=new RequestParams();
        params.put("username",editUser.getText().toString());
        params.put("password",editPass1.getText().toString());
        params.put("sex",gender+"");

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

                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        saveData();

    }

    private void saveData() {
        String user=editUser.getText().toString();

    }
}
