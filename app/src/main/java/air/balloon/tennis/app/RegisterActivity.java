package air.balloon.tennis.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import air.balloon.tennis.parent.BaseActivity;


public class RegisterActivity extends BaseActivity {

    EditText editUser,editPass1,editPass2;

    Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitleOnTopBar(getString(R.string.register));
    }



}
