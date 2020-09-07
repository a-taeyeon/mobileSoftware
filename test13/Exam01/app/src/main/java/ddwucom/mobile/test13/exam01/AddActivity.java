package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etAddFood;
    EditText etAddNation;

    FoodDBHelper myDbHelper;
    ContentValues row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myDbHelper = new FoodDBHelper(this);

        etAddFood = findViewById(R.id.etAddFood);
        etAddNation = findViewById(R.id.etAddNation);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();
        row = new ContentValues();
        switch (v.getId()){
            case R.id.btnAddFood:
                row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etAddFood.getText().toString());
                row.put(FoodDBHelper.COL_NATION, etAddNation.getText().toString());
                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);
                break;

            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
