package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
//        버튼의 종류에 따라 결과 설정 후 finish()
//        Intent intent = new Intent();

//        intent.putExtra("food", "음식이름");
//        intent.putExtra("nation", "나라이름");
        //위에 두 문장 대신 Food객체를 이용해서 newfood를 만듦
//        Food newfood = new Food("음식", "나라이름");

        switch (v.getId()){
            case R.id.btn_add:
                Intent resultIntent = new Intent();
                Food newfood = new Food(etFood.getText().toString(), etNation.getText().toString());
                resultIntent.putExtra("food", newfood);
                setResult(RESULT_OK, resultIntent);
              break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}

