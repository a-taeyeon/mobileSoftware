package ddwucom.mobile.test12.practice12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnMain:
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                editText = (EditText)findViewById(R.id.etMain);
                str = editText.getText().toString();

                intent.putExtra("str", str);

                startActivity(intent);
                break;
        }

    }
}
