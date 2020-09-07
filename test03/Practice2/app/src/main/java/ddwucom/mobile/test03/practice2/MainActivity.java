package ddwucom.mobile.test03.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        switch(v.getId()){
            case R.id.btnOne:
                msg += "1";
                break;
            case R.id.btnTwo:
                msg += "2";
                break;
            case R.id.btnThree:
                msg += "3";
                break;
            case R.id.btnClear:
                msg = "";
                break;
        }

        TextView textView = findViewById(R.id.editText);
        textView.setText(msg);
    }
}
