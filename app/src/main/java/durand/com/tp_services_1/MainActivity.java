package durand.com.tp_services_1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;


    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart = (Button) findViewById(R.id.startalarm);
        Button buttonCancel = (Button) findViewById(R.id.cancelalarm);
        buttonStart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(MainActivity.this, MyService.class);
                pendingIntent = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);

                //Setting up an alamManager
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 15);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                // Tell user we have launched the service
                Toast.makeText(MainActivity.this, "Start Alarm", Toast.LENGTH_SHORT).show();
            }
        });
        buttonCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                // Tell the user about what we did.
                Toast.makeText(MainActivity.this, "Cancel!", Toast.LENGTH_LONG).show();
            }
        });
    }
}