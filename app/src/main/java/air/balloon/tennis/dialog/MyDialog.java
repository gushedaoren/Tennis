package air.balloon.tennis.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.List;

import air.balloon.tennis.app.R;

/**
 * Created by oliver on 5/17/14.
 */
public class MyDialog {
    Context context;

    public MyDialog(Context context) {
        this.context = context;
    }

   public void showExitDialg(final List<Activity> activities){
       AlertDialog.Builder builder = new AlertDialog.Builder(context);
       builder.setIcon(R.drawable.ic_launcher);
       builder.setTitle(context.getString(R.string.app_name));
       builder.setMessage(context.getString(R.string.exit_dialog_message));
       builder.setPositiveButton(context.getString(R.string.OK),
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {


                       for (Activity activity : activities) {
                           activity.finish();
                       }

                   }
               });

       builder.setNegativeButton(context.getString(R.string.Cancel),
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int whichButton) {

                   }
               });


       builder.show();

   }
}
