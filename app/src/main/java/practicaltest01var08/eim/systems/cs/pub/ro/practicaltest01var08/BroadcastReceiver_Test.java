package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by student on 02.04.2018.
 */

public class BroadcastReceiver_Test extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if(action.equals("act")) {
            String str2 = intent.getStringExtra("msg");

            Toast.makeText(context, str2,
                    Toast.LENGTH_LONG).show();
        }
    }
}
