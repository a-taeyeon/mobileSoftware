package ddwucom.mobile.test06.practice6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textView;
    EditText editText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnDisplay);

     /*2.1방법: 별도의 리스너 인터페이스 구현 클래스 작성
        MyClick myClick = new MyClick();
        btn.setOnClickListener(myClick);    */

     /*2.4방법: 익명 내부 클래스 구현으로 작성
        btn.setOnClickListener(myClickListener);    */

     /*2.5방법: 익명 내부 클래스의 임시 객체 구현 방법으로 작성
        btn.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View v) {
                 editText = (EditText)findViewById(R.id.editText);
                 textView = findViewById(R.id.tvDisplay);
                 text = editText.getText().toString();
                 textView.setText(text);
         }
     });    */

    }



    /*2.1방법: 별도의 리스너 인터페이스 구현 클래스 작성
    class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            editText = (EditText)findViewById(R.id.editText);
            textView = findViewById(R.id.tvDisplay);
            text = editText.getText().toString();
            textView.setText(text);
        }
    }   */

    /*2.4방법: 익명 내부 클래스 구현으로 작성
    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            editText = (EditText)findViewById(R.id.editText);
            textView = findViewById(R.id.tvDisplay);
            text = editText.getText().toString();
            textView.setText(text);
        }
    };  */

}
