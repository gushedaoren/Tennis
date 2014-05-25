package air.balloon.tennis.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import air.balloon.tennis.adapter.CityAdapter;
import air.balloon.tennis.app.R;
import air.balloon.tennis.db.MyDatabase;
import air.balloon.tennis.model.BaseCity;
import indexable.IndexableListView;


/**
 * Created by oliver on 5/17/14.
 */
public class MyDialog {
    Context context;

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


    public void showChangeCityDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_change_city, null);

        IndexableListView indexableListView= (IndexableListView) view.findViewById(R.id.listView);
        indexableListView.setFastScrollEnabled(true);

        List<BaseCity> citys=getCitys();

        CityAdapter adapter=new CityAdapter(context,citys);
        indexableListView.setAdapter(adapter);

        builder.setView(view);
        final AlertDialog dialog = builder.show();

    }

    private List<BaseCity> getCitys() {
        List<BaseCity> cities=new ArrayList<BaseCity>();
        SQLiteDatabase db= MyDatabase.getInstance(context);
        String sql="SELECT * FROM city order by isHot desc, firstLetter";
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
