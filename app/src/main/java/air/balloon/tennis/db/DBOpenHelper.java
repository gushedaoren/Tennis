package air.balloon.tennis.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    String databaseName;

    public DBOpenHelper(Context context) {


        super(context, Config.DatabaseName, null, Config.DATABASE_VERSION);
        this.context=context;
        this.databaseName=Config.DatabaseName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        MyLog.print(TAG, "onCreate");
        copyDatabase();

    }






    public void copyDatabase(){


        // Open your local db as the input stream
        InputStream myInput = context.getResources()
                .openRawResource(R.raw.tennis);
        // Path to the just created empty db
        String outFileName = "/data/data/"+context.getPackageName()+"/"+databaseName;
        Log.i(getClass().getSimpleName(),"copyDatabase:"+outFileName );


        // Open the empty db as the output stream
        OutputStream myOutput = null;
        try {

            File file=new File(outFileName);
            if(file.exists())file.delete();

            myOutput = new FileOutputStream(outFileName);

            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        MyLog.print(TAG,"onUpgrade");
    }
}
