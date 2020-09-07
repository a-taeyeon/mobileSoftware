package ddwucom.mobile.test14.exam02;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null;
//    FoodDBHelper dbHelper;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList<Food>();
        adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("food", food);  //수정해야할 값을 갖고있는 food객체 -> UpdateActivity에서 DB작업
                /*기억해야될 것!
                객체를 담을 때 Food food객체를 putExtra해서 intent에 담을 수 있는 이유는
                Food 객체 자체가 Serializable 인터페이스를 구현하는 클래스로 만들어졌기때문!
                 */
                startActivityForResult(intent, UPDATE_CODE); //업데이트를 했는지 안했는지 구분해주기 위해서 startActivity가 아닌 startActivityForResult로 해주는게 좋음
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int pos = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);   //그냥 this넣으면 Listener객체가 들어가가버림.
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                boolean result = foodDBManager.removeFood(foodList.get(pos).get_id());
                                if(result){ //삭제됐는지 확인하는 작업
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();

                                    //화면 갱신
                                    foodList.clear();
                                    foodList.addAll(foodDBManager.getAllFood());
                                    adapter.notifyDataSetChanged();
                                }else{
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    //DBManger를 이용해서 써줬음
//    private void deleteRecord(int pos){ //삭제하는 작업
//
//        FoodDBHelper foodDBHelper = new FoodDBHelper(this);
//        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
//        String whereClause = FoodDBHelper.COL_ID + "=?";
//        String[] whereArgs = new String[] {String.valueOf(foodList.get(pos).get_id())};
//        /*주의!!!
//         리스트뷰를 롱클릭했을 때 들어오는 위치는 position이고, 실제 우리가 사용하는 것은 id다.
//         그럼 position위치에 해당하는 객체를 먼저 확인하고나서 그 id를 알아내서 사용해야된다는 것을 기억!
//         (나중에 CursorAdapter를 쓸 때는 바로 id값 사용가능)
//         */
//
//        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
//        if(result > 0){ //삭제됐는지 확인하는 작업
//            Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show();
//
//            //화면 갱신
//            foodList.clear();
//            foodList.addAll(foodDBManager.getAllFood());
//            adapter.notifyDataSetChanged();
//        }else{
//            Toast.makeText(this, "삭제 실패", Toast.LENGTH_SHORT).show();
//        }
//
//        foodDBHelper.close();   //잊지말고 닫아주기
//    }

    @Override
    protected void onResume() {
        super.onResume();
        foodList.clear();
        foodList.addAll(foodDBManager.getAllFood());
        adapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch(resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, food + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch(resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
