package air.balloon.tennis.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import air.balloon.tennis.adapter.CityAdapter;

import air.balloon.tennis.app.R;
import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.model.BaseCity;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.Preference;
import indexable.IndexableListView;


/**
 * Created by oliver on 5/17/14.
 */
public class MyDialog {
    Context context;
    String TAG="MyDialog";

    public MyDialog(Context context) {
        this.context = context;
    }

    public void showExitDialg(final List<Activity> activities) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_exit, null);

        Button btnOK, btnCancel;

        btnCancel = (Button) view.findViewById(R.id.Cancel);
        btnOK = (Button) view.findViewById(R.id.OK);

        builder.setView(view);

        final AlertDialog dialog = builder.show();


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                for (Activity activity : activities) {
                    activity.finish();
                }
            }
        });

    }
    List<BaseCity> citys;

    public void showChangeCityDialog(){


        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_change_city, null);

        final IndexableListView indexableListView= (IndexableListView) view.findViewById(R.id.listView);
        indexableListView.setFastScrollEnabled(true);

        citys=getCitys("");

        CityAdapter adapter=new CityAdapter(context,citys);
        indexableListView.setAdapter(adapter);


        final EditText editText= (EditText) view.findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyWord=editText.getText().toString();
                MyLog.print(TAG,"keyWord:"+keyWord);
                citys=getCitys(keyWord);
                CityAdapter adapter=new CityAdapter(context,citys);
                indexableListView.setAdapter(adapter);
            }
        });




        builder.setView(view);
        final AlertDialog dialog = builder.show();


        indexableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sp=context.getSharedPreferences(Preference.SP,Context.MODE_PRIVATE);
                BaseCity city=citys.get(position);
                MyLog.print(TAG,"city:"+city.getCityName());
                sp.edit().putString("city",city.getCityName()).commit();
                dialog.dismiss();
                ((Activity)context).invalidateOptionsMenu();
            }
        });






    }

    private List<BaseCity> getCitys(String keyWord) {
        List<BaseCity> cities=new ArrayList<BaseCity>();
        SQLiteDatabase db= MyDatabase.getInstance(context);
        String sql="SELECT * FROM city  where cityName like '"+keyWord+"%' order by isHot desc, firstLetter";
        MyLog.print(TAG,sql);
        Cursor cursor=db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            BaseCity city=new BaseCity();
            city.setId(cursor.getLong(cursor.getColumnIndexOrThrow("cityId")));
            city.setCityName(cursor.getString(cursor.getColumnIndexOrThrow("cityName")));
            city.setFirsrLetter(cursor.getString(cursor.getColumnIndexOrThrow("firstLetter")));
            int hot=cursor.getInt(cursor.getColumnIndexOrThrow("isHot"));
            if(hot==1){
                city.setHot(true);
            }else city.setHot(false);
            cities.add(city);
        }

        cursor.close();

        return cities;
    }
}
