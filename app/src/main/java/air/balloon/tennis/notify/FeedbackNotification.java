package air.balloon.tennis.notify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import air.balloon.tennis.app.R;
import umeng.fb.ConversationActivity;

/**
 * Created by oliver on 4/20/14.
 */
public class FeedbackNotification {


    Context context;

    public FeedbackNotification(Context context) {
        this.context = context;
    }


    public void showNofity() {

        Intent resultIntent = new Intent(context, ConversationActivity.class);

        // Because clicking the notification opens a new ("special") activity, there's
// no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(resultPendingIntent).setContentText(context.getString(R.string.notify_feedback))
                        .setContentTitle(context.getString(R.string.app_name));
        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification=mBuilder.build();

        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        notification.flags=Notification.FLAG_AUTO_CANCEL;
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, notification);

    }
}
