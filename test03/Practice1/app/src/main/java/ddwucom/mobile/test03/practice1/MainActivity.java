package ddwucom.mobile.test03.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onHelloBtnClick(View v){

        EditText name = (EditText)findViewById(R.id.etName);
        EditText phone = (EditText)findViewById(R.id.etPhone);
        String msg = "안녕하세요, 저는 " + name.getText().toString() + "입니다. \n전화번호는 " + phone.getText().toString() + "입니다.";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onExitBtnClick(View v){
        finish();
    }
}
