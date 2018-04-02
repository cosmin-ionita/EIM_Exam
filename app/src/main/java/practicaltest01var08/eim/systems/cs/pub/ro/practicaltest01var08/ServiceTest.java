package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

public class ServiceTest extends Service {
    public ServiceTest() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private String getMaskedString(String str) {

        StringBuilder builder = new StringBuilder(str);

        Random random = new Random();

        int x = random.nextInt(str.length());

        for(int i = 0; i < str.length(); i++) {

            if(i != x)
                builder.setCharAt(i, '*');
        }

        return builder.toString();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final String str = intent.getStringExtra("answer");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {

                    String str2 = getMaskedString(str);

                    Intent intent = new Intent();

                    intent.setAction("act");

                    intent.putExtra("msg", str2);

                    sendBroadcast(intent);

                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
