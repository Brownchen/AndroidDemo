package brown.example.com.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentTitle("This is content title");
                builder.setContentText("This is content text");
                builder.setAutoCancel(true);
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pi);
                Notification notification = builder.getNotification();
                manager.notify(1,notification);
                //manager.cancel(1);
            }
        });
    }
}
