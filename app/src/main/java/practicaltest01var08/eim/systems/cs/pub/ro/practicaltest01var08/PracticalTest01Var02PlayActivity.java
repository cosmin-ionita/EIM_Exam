package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

    Intent serviceIntent = new Intent();

    BroadcastReceiver receiver = new BroadcastReceiver_Test();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        Intent intent = getIntent();

        TextView riddle_activ_2 = findViewById(R.id.riddle_activ_2);
        TextView answer_activ_2 = findViewById(R.id.answer_activ_2);

        String riddle = intent.getStringExtra("riddle_key");
        String answer = intent.getStringExtra("answer_key");

        if(riddle != null && answer != null) {
            riddle_activ_2.setText(riddle);
            answer_activ_2.setText(answer);
        }

        serviceIntent.setComponent(new ComponentName("practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08", "practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08.ServiceTest"));

        serviceIntent.putExtra("answer", answer);

        startService(serviceIntent);
    }

    public void check_click(View view) {
        EditText edit = findViewById(R.id.editable_text);
        TextView answer_activ_2 = findViewById(R.id.answer_activ_2);

        String str = edit.getText().toString();
        String str2 = answer_activ_2.getText().toString();

        if(str.equals(str2)) {
            Toast.makeText(this, "True",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "False",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void back_click(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        stopService(serviceIntent);

        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();

        filter.addAction("act");

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }
}
