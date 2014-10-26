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
        CopyAndLoadDB();

    }






    // 复制和加载区域数据库中的数据
    private void CopyAndLoadDB() {
        // 打开静态数据库文件的输入流

        String dPath="/data/data/"+context.getPackageName()+"/databases/"+databaseName;
        File file=new File(dPath);
        if(file.exists()){
            file.delete();
        }
        InputStream is = context.getResources().openRawResource(R.raw.tennis);
        // 通过Context类来打开目标数据库文件的输出流，这样可以避免将路径写死。
        FileOutputStream os;
        try {
            os = new FileOutputStream(dPath);
            byte[] buffer = new byte[1024];
            int count = 0;
            // 将静态数据库文件拷贝到目的地
            while ((count = is.read(buffer)) > 0) {
                os.write(buffer, 0, count);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        MyLog.print(TAG,"onUpgrade");
    }
}
