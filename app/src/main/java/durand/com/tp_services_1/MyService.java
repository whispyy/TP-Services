package durand.com.tp_services_1;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Service.onCreate()", Toast.LENGTH_LONG).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Service.onBind()", Toast.LENGTH_LONG).show();
        return null;
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(this, "Service.onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flag, int startId){
        //Here must be the code to execute in service
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("Service");
        mBuilder.setContentText("Execution en cours");
        final int notificationID = 1;
        final NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
        //Here end the code to execute

        super.onStartCommand(intent,flag,startId);
        Toast.makeText(this, "Service.onStartCommand()",Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;
    }



    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Service.onUnbind()", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }



    /*
    Ancienne façon de créer un service.
    Maintenant remplacée par onStartCommand
    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        Toast.makeText(this, "Service.onStart()", Toast.LENGTH_LONG).show();
    }
    */
}
