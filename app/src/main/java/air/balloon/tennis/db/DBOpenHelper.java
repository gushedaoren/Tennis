package air.balloon.tennis.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import air.balloon.tennis.app.R;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.Config;

/**
 * Created by oliver on 3/31/14.
 */




public class DBOpenHelper extends SQLiteOpenHelper {

    private final String TAG="DBOpenHelper";
    Context context;

    public DBOpenHelper(Context context) {


        super(context, Config.DatabaseName, null, Config.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        MyLog.print(TAG, "onCreate");
        createDatabase(db);

    }

    private void createDatabase(SQLiteDatabase db) {
         String[] sqls=readFile();

        MyLog.print(TAG,"sql length:"+sqls.length);
        for(int i=0;i<sqls.length-1;i++){
            if(sqls[i].equals(""))continue;
            MyLog.print(TAG,sqls[i]);
            db.execSQL(sqls[i]+";");
        }




    }





    private String[] readFile() {

        String[] sqls=null;
        String result="";
        try {




            InputStream is = context.getResources().openRawResource(R.raw.schema_sqlite);
            int size = is.available();


            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            result = new String(buffer, "UTF-8");

        //    MyLog.print(TAG,"sql:"+result);

            sqls=result.split(";");



        } catch (Exception e) {
             Log.e(TAG,e.toString());
        }
          return sqls;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        MyLog.print(TAG,"onUpgrade");
    }
}
