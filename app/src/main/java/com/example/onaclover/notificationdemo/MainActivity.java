package com.example.onaclover.notificationdemo;

import android.annotation.TargetApi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String ID = "com.example.onaclover.notificationdemo";
    Button btn;
    EditText title,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String contentText = "The priority determines how intrusive the notification should be on Android 7.1 and lower. (For Android 8.0 and higher," +
                " you must instead set the channel importance—shown in the next section.)";

        //notiHelper = new NotiHelper(this);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), ID)
                        .setSmallIcon(R.drawable.yoga)
                        .setContentTitle("Hello Noti")
                        .setContentText(contentText)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(myBitmap)
                        .bigLargeIcon(myBitmap))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager manager = getNotificationManager();
                manager.notify(new Random().nextInt(), mBuilder.build());

//                Notification.Builder builder = new Notification.Builder(getApplicationContext());
//                builder.setContentTitle("BP notification")
//                        // Notification title
//                        .setContentText("BigPicutre notification")
//                        // you can put subject line.
//                        .setSmallIcon(R.drawable.yoga);
//                        // Set your notification icon here.
//
//                // Now create the Big picture notification.
//                Notification notification = new Notification.BigPictureStyle(builder)
//                        .bigPicture(
//                                BitmapFactory.decodeResource(getResources(),
//                                        R.drawable.aaa)).build();
//                // Put the auto cancel notification flag
//                notification.flags |= Notification.FLAG_AUTO_CANCEL;
//                NotificationManager notificationManager = getNotificationManager();
//                notificationManager.notify(0, notification);
            }
        });
    }

    public NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
