package air.balloon.tennis.app;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
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
        initData();

        if(court.getAddress()!=null||court.getAddress().length()>0){
            txt3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
            txt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMap(court.getAddress());
                }
            });
        }

    }

    private void initData() {


                court= (Court) getIntent().getSerializableExtra("court");
                txt1.setText(court.getTitle());
                txt2.setText(Html.fromHtml(court.getDescription().replace(" ","")));
                txt3.setText(court.getAddress());
                txt4.setText(court.getPhone());
                txt5.setText(court.getCourt_number());

    }


    private void openMap(String location){
        // Uri uri = Uri.parse("geo:39,116");
        try {

            Uri uri = Uri.parse("geo:0,0?q="+location);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {


            String str="http://ditu.google.cn/?q="+location;
            Uri uri = Uri.parse(str);
            //通过Uri获得编辑框里的//地址，加上http://是为了用户输入时可以不要输入
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //建立Intent对象，传入uri
            startActivity(intent);

        }
    }
}
