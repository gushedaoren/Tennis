package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


/**
 * A login screen that offers login via email/password and via Google+ sign in.
 * <p/>
 * ************ IMPORTANT SETUP NOTES: ************
 * In order for Google+ sign in to work with your app, you must first go to:
 * https://developers.google.com/+/mobile/android/getting-started#step_1_enable_the_google_api
 * and follow the steps in "Step 1" to create an OAuth 2.0 client for your package.
 */
public class LoginActivity extends BaseActivity implements OnClickListener{
    LinearLayout btnSignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitleOnActionBar(getString(R.string.login));
        findViews();


    }


    private void findViews() {


        btnSignup= (LinearLayout) findViewById(R.id.signup);
        btnSignup.setOnClickListener(this);


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

            default:
                break;

        }
    }
}


