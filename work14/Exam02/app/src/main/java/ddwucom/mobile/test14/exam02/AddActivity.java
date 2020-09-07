package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

//    FoodDBHelper dbHelper;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        foodDBManager = new FoodDBManager(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                //DB관련 부분 삭제 후 Food 객체를 화면 입력값으로 생성한 코드 결과
                boolean result = foodDBManager.addNewFood(
                        new Food(etFood.getText().toString(), etNation.getText().toString())
                );

                if(result){ //정상수행에 따른 처리
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", etFood.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }   else{   //이상에 따른 처리
                    Toast.makeText(this, "새로운 음식 추가 실패!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
