package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;
    ContentValues row;
    String whereClause;
    String[] whereArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {

        SQLiteDatabase myDB = myDbHelper.getWritableDatabase(); //읽기,쓰기 겸용
//        SQLiteDatabase myDB = myDbHelper.getReadableDatabase(); //읽기(select)전용

        row = new ContentValues();

        switch(v.getId()) {
            case R.id.btnSelect:
//                String selection = "food=?";
//                String[] selectArgs = new String[] {"된장찌개"};

//                //메소드사용
//                Cursor cursor =
//                        myDB.query(FoodDBHelper.TABLE_NAME, null, selection,
//                                selectArgs, null, null, null, null);
//
//                //SQL 직접사용
//                cursor = myDB.rawQuery("select * from " + FoodDBHelper.TABLE_NAME
//                                    + " where food = '된장찌개'", null);

                //메소드사용해서 전체 출력
                Cursor cursor = myDB.query(FoodDBHelper.TABLE_NAME, null, null, null,
                        null, null, null, null);

                //결과 출력
                String result = "";
                while(cursor.moveToNext()){
                    result += cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION)) + "\n";
                }
                tvDisplay.setText(result);
                cursor.close(); //cursor도 사용이 다 끝난 후 반드시 close해줘야함.

                break;

    //실습2
            case R.id.btnAdd:
                Intent intentAdd = new Intent(this, AddActivity.class);
                startActivity(intentAdd);
                break;
            case R.id.btnUpdate:
                Intent intentUpdate = new Intent(this, UpdateActivity.class);
                startActivity(intentUpdate);
                break;
            case R.id.btnRemove:
                Intent intentRemove = new Intent(this, RemoveActivity.class);
                startActivity(intentRemove);
                break;

/*  //실습1
            case R.id.btnAdd:
                //메소드 사용
//                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, "소고기쌀국수");
                //-> String food로 음식 이름을 정해줬을때 그냥 "소고기쌀국수"자리에 food만 넣어주면 됨
                row.put(FoodDBHelper.COL_NATION, "태국");
                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);

                //SQL 사용 -> 매우복잡
                String food = "김치";
                myDB.execSQL("insert into " + FoodDBHelper.TABLE_NAME
                            + " values (null, '" + food + "', '한국')");

                break;

            case R.id.btnUpdate:
//                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, "미역국");
                row.put(FoodDBHelper.COL_NATION, "대한민국");

                whereClause = "_id=?";
                whereArgs = new String[]{Integer.toString(1)};

                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

                break;

            case R.id.btnRemove:
                whereClause = "_id=?";
                whereArgs = new String[]{Integer.toString(2)};
                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
//                myDB.delete(FoodDBHelper.TABLE_NAME, null, null);   //전체삭제
                break;
 */       }

        myDbHelper.close();
    }

}
