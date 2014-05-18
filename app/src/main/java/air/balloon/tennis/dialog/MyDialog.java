package air.balloon.tennis.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

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
//       builder.setIcon(R.drawable.ic_launcher);
//       builder.setTitle(context.getString(R.string.app_name));
//       builder.setMessage(context.getString(R.string.exit_dialog_message));
//       builder.setPositiveButton(context.getString(R.string.OK),
//               new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int whichButton) {
//
//                       dialog.dismiss();
//
//                       for (Activity activity : activities) {
//                           activity.finish();
//                       }
//
//                   }
//               });
//
//       builder.setNegativeButton(context.getString(R.string.Cancel),
//               new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int whichButton) {
//
//                   }
//               });

         View view=LayoutInflater.from(context).inflate(R.layout.dialog_exit,null);

       Button btnOK,btnCancel;

       btnCancel= (Button) view.findViewById(R.id.Cancel);
       btnOK= (Button) view.findViewById(R.id.OK);



        builder.setView(view);






          final AlertDialog dialog=  builder.show();


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
}
