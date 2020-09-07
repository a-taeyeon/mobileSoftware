package ddwucom.mobile.test10.practice10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();

        ArrayList<MyData> dataList = dataManager.getDataList();

        adapter = new MyAdapter(this, R.layout.custom_adapter_view, dataManager.getDataList());


        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataManager.removeData(position); //이것만 써주면 원본데이터에서만 사라지고 화면에서는 사라지지 않아서
                // 화면순서와 subjectManager가 갖고 있는 arrayList 항목의 개수와 순서가 일치되지 않기때문에 앱이 죽어버림.

                adapter.notifyDataSetChanged(); //그렇기 이걸 호출해서 바뀐 원본데이터를 알려줄테니 갱신하라고 알려줌.

                return true;    //인터페이스 처리가 끝나면 true를 반환하면 됨
            }
        });

    }
}
