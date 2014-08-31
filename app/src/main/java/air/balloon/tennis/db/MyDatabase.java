package air.balloon.tennis.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by oliver on 4/1/14.
 */
public class MyDatabase {

   public static SQLiteDatabase db;

    public static SQLiteDatabase getInstance(Context context){

        if(db!=null&&db.isOpen())return db;

        return new DBOpenHelper(context).getWritableDatabase();

    }

}
