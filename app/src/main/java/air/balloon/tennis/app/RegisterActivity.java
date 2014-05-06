package air.balloon.tennis.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    EditText editUser,editPass1,editPass2;

    Button btnSubmit;

    CheckBox checkMan,checkWoman;
    String gender="man";

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
                    gender="man";
                    MyLog.print(TAG,"gender:"+gender);
                }


            }
        });
        checkWoman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkMan.setChecked(false);
                    gender="woman";
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

                doSubmit();

                break;
        }

    }

    private void doSubmit() {
        AsyncHttpClient client=new AsyncHttpClient();
        String url= API.REGISTER;
        client.get(url,new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);



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
