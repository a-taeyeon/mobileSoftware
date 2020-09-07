package ddwucom.mobile.test11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것
//        foodList = new ArrayList<Food>();
//        foodList.add(new Food("김치찌개", "한국"));   //DTO형태로정의된거임(Food객체가 문자열로 바뀌어서 보여짐)
//        foodList.add(new Food("된장찌개", "한국"));
//        foodList.add(new Food("훠궈", "중국"));
//        foodList.add(new Food("딤섬", "중국"));
//        foodList.add(new Food("초밥", "일본"));
//        foodList.add(new Food("오코노미야키", "일본"));

        manager = new FoodManager();

        // Food 객체의 toString()메소드가 호출되어 하나의 문자열로 처리됨
        foodList = manager.getFoodList();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final int index = position; //매개변수 position을 Dialog에서 직접 바로 쓸 수 없는 이유는
                // 객체의 범위도 다를뿐더러 매개변수니까 지역변수처럼 취급이되서 이 부분이 바로 실행이 끝나면 사라지는데 Dialog는 Modelless처럼 동작함

                String food = foodList.get(position).getFood();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(food + "(을)를 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //원본 데이터를 사제 ->manager클래스가 담당
                                manager.deleteFood(index);

                                //화면에 반영 ->listView가 연결된 adapter에 알려줌
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    public void onClick(View v){

        final ConstraintLayout addLayout = (ConstraintLayout) View.inflate(this, R.layout.add_layout, null);

        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("음식 추가")
                        .setView(addLayout)
                        .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               //다이얼로그 레이아웃에 있는 et를 가져와서 문자열로 읽어옴
                                EditText etName = addLayout.findViewById(R.id.etName);
                                EditText etCountry = addLayout.findViewById(R.id.etCountry);

                                String name = String.valueOf(etName.getText());
                                String country = String.valueOf(etCountry.getText());

                                manager.addFoodd(new Food(name, country));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                break;
        }
    }
}

