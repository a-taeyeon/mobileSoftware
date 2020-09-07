package ddwucom.mobile.test04.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout; //멤버변수로 선언. 그런데 여기서 프로그램을 실행하는 부분(메소드 호출부분)이 있으면 안됨.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout); //실행(메소드 호출)은 여기서
    }

    public void onClick (View v){

        switch(v.getId()){
            case R.id.btnVertical:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btnHorizontal:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }

    }
}
