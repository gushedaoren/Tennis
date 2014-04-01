package air.balloon.tennis.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.parent.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener{


    LinearLayout btnLeft1,btnLeft2,btnLeft3,btnRight1,btnRight2,btnRight3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= MyDatabase.getInstance(this);
        printChanel();

        findViews();

    }


    private void findViews(){

        btnLeft1= (LinearLayout) findViewById(R.id.btn_left1);

        btnLeft2=(LinearLayout) findViewById(R.id.btn_left2);

        btnLeft3=(LinearLayout) findViewById(R.id.btn_left3);

        btnRight1=(LinearLayout) findViewById(R.id.btn_right1);

        btnRight2=(LinearLayout) findViewById(R.id.btn_right2);

        btnRight3=(LinearLayout) findViewById(R.id.btn_right3);


        btnLeft1.setOnClickListener(this);
        btnLeft2.setOnClickListener(this);
        btnLeft3.setOnClickListener(this);


        btnRight1.setOnClickListener(this);
        btnRight2.setOnClickListener(this);
        btnRight3.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_left1:

                break;
            case R.id.btn_left2:


                break;
            case R.id.btn_left3:


                break;
            case R.id.btn_right1:


                break;
            case R.id.btn_right2:
                intent.setClass(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_right3:


                break;
            default:
                break;
        }
    }
}
