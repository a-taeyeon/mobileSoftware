package ddwucom.mobile.test04.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_main);

        LinearLayout layout =  findViewById(R.id.linearLayout);

        if (layout.getOrientation() == LinearLayout.VERTICAL){
            Log.d(TAG, "Vertical!");
        }

        layout.setOrientation(LinearLayout.HORIZONTAL);
    }
}
