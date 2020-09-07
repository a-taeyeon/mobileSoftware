package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText etUpdateId;
    EditText etUpdateFood;

    FoodDBHelper myDbHelper;
    ContentValues row;
    String whereClause;
    String[] whereArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDbHelper = new FoodDBHelper(this);

        etUpdateId = findViewById(R.id.etUpdateId);
        etUpdateFood = findViewById(R.id.etUpdateFood);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();
        row = new ContentValues();
        switch (v.getId()){
            case R.id.btnUpdateFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etUpdateFood.getText().toString());

                whereClause = "_id=?";
                whereArgs = new String[]{etUpdateId.getText().toString()};

                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);
                break;

            case R.id.btnUpdateCancel:

                break;
        }
        myDbHelper.close();
        finish();
    }
}
