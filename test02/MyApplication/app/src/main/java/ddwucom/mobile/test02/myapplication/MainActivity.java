package ddwucom.mobile.test02.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

       TextView myText = new TextView(this);
        String text = "Android Programming!";
        // ...
        text = "mobile";
        // ...
        myText.setText(text);
        setContentView(myText);

    }
}
