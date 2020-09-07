package ddwucom.mobile.test04.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg = "";
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_1:
                msg += "1";
                break;
            case R.id.btn_2:
                msg += "2";
                break;
            case R.id.btn_plus:
                num = Integer.parseInt(msg);
                msg = "";
                break;
            case R.id.btn_equal:
                num += Integer.parseInt(msg);
                msg = Integer.toString(num);
                break;
        }

        TextView textView = findViewById(R.id.etDisplay);
        textView.setText(msg);
    }
}