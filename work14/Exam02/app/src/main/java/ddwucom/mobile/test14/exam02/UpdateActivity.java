package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    Food food;

    EditText etFood;
    EditText etNation;

    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        etFood.setText(food.getFood());
        etNation.setText(food.getNation());

        foodDBManager = new FoodDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                String foodName = etFood.getText().toString();
                String nation = etNation.getText().toString();

                food.setFood(foodName);
                food.setNation(nation);

                if(foodDBManager.modifyFood(food)){ //업데이트 성공
                    Intent resultIntent = new Intent();
                    /*주의! startActivity()하면 안됨
                    startActivity하게되면 updateActivity위에 MainActivity가 또 뜨게됨*/

                    resultIntent.putExtra("food", food);    //바뀐 food객체
                    setResult(RESULT_OK, resultIntent);
                }   else {//업데이트 실패
                    setResult(RESULT_CANCELED);
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
