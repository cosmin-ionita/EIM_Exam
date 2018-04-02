package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        EditText riddle = findViewById(R.id.riddle);
        EditText answer = findViewById(R.id.answer);

        String str1 = savedInstanceState.getString("riddle");
        String str2 = savedInstanceState.getString("answer");

        riddle.setText(str1);
        answer.setText(str2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText riddle = findViewById(R.id.riddle);
        EditText answer = findViewById(R.id.answer);

        String str1 = riddle.getText().toString();
        String str2 = answer.getText().toString();

        outState.putString("riddle", str1);
        outState.putString("answer", str2);
    }

    public void play_click(View view) {
        EditText riddle = findViewById(R.id.riddle);
        EditText answer = findViewById(R.id.answer);

        String str1 = riddle.getText().toString();
        String str2 = answer.getText().toString();

        if(!str1.equals("") &&  !str2.equals("")) {

            Intent intent = new Intent(this, PracticalTest01Var02PlayActivity.class);

            String riddle_text = riddle.getText().toString();
            String answer_text = answer.getText().toString();

            intent.putExtra("riddle_key", riddle_text);
            intent.putExtra("answer_key", answer_text);

            startActivity(intent);
        }
    }
}
