package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    EditText etRemoveFood;

    FoodDBHelper myDbHelper;
    ContentValues row;
    String whereClause;
    String[] whereArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        myDbHelper = new FoodDBHelper(this);

        etRemoveFood = findViewById(R.id.etRemoveFood);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();
        row = new ContentValues();
        switch (v.getId()){
            case R.id.btnRemoveFood:
                whereClause = "food=?";
                whereArgs = new String[]{etRemoveFood.getText().toString()};
                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
                break;

            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
