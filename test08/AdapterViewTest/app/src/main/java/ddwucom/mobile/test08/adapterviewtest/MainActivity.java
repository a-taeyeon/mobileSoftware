package ddwucom.mobile.test08.adapterviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    subjectManager subjectManager;
    ArrayAdapter<String> adapter;
    ListView listView;

    EditText editText;

    int selectedPos; //클릭한 위치 기억

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedPos = 0; //초기화
        editText = findViewById(R.id.editText);

        subjectManager = new subjectManager();

        final ArrayList<String> subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show();

               selectedPos = position; //현재 선택한 위치를 기록

            //클릭하면 editText에 클릭한 값 나오게함함
            String subject = subjectManager.getItem(position);
            editText.setText(subject);
           }
       });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                subjectManager.removeData(position); //이것만 써주면 원본데이터에서만 사라지고 화면에서는 사라지지 않아서
                // 화면순서와 subjectManager가 갖고 있는 arrayList 항목의 개수와 순서가 일치되지 않기때문에 앱이 죽어버림.

                adapter.notifyDataSetChanged(); //그렇기 이걸 호출해서 바뀐 원본데이터를 알려줄테니 갱신하라고 알려줌.

                return true;    //인터페이스 처리가 끝나면 true를 반환하면 됨
            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                String data = editText.getText().toString(); //꼭 toString으로 문자열로 변환시켜줘야함. 안그러면 character sequence라는 객체를 반환함.
                subjectManager.addData(data); //이것만 써주면 원본데이터가 화면에 반영이 안됨.
                adapter.notifyDataSetChanged(); //반드시 원본데이터가 바뀌었음을 화면에 알려줌
                break;

            case R.id.button2:
                String updateData = editText.getText().toString();
                subjectManager.updateData(selectedPos, updateData);//원본 데이터 수정 (위치, 바꿀내용)
                adapter.notifyDataSetChanged();//어뎁터에 알림
                break;
        }
    }
}
